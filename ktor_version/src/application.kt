package com.federico.d.bernst

import com.federico.d.bernst.controller.homeContoller
import com.federico.d.bernst.controller.loginContoller
import com.federico.d.bernst.controller.response.LoginResponse
import com.federico.d.bernst.controller.service.HomeService
import com.federico.d.bernst.controller.service.LoginService
import com.federico.d.bernst.excepcion.FailAuthException
import com.federico.d.bernst.koin.persistenseModule
import com.federico.d.bernst.koin.serviceModule
import com.federico.d.bernst.security.ClientSession
import com.federico.d.bernst.security.GuestSession
import com.federico.d.bernst.security.JWTAuthClass
import com.federico.d.bernst.security.UserSession
import com.federico.d.bernst.view.homeView
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authenticate
import io.ktor.auth.jwt.jwt
import io.ktor.auth.principal
import io.ktor.content.resources
import io.ktor.content.static
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie
import kotlinx.css.CSSBuilder
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.FlowOrMetaDataContent
import kotlinx.html.style
import org.koin.ktor.ext.inject
import org.koin.standalone.StandAloneContext.startKoin

fun main(args: Array<String>): Unit = io.ktor.server.netty.DevelopmentEngine.main(args)


fun Application.module() {
    startKoin(listOf(persistenseModule, serviceModule))

    val jwtAuthClass: JWTAuthClass by inject()

    //	Features
    install(Authentication) {
        jwt {
            realm = jwtAuthClass.realm
            verifier(jwtAuthClass.verifier)
            validate {
                UserIdPrincipal(it.payload.getClaim(JWTAuthClass.claimName).asString())
            }
        }
    }
    install(Sessions) {
        cookie<ClientSession>(ClientSession.sessionName) // install a cookie stateless session
        cookie<GuestSession>(GuestSession.sessionName) // install a cookie stateless session
        cookie<UserSession>(UserSession.sessionName) // install a cookie stateless session
    }
    install(StatusPages) {
        exception<Throwable> { cause ->
            cause.printStackTrace()
            call.respond(HttpStatusCode.InternalServerError, mapOf("error" to cause.message, "trace" to cause.stackTrace))
        }
        exception<FailAuthException> { exception ->
            call.respond(HttpStatusCode.Unauthorized, LoginResponse(mensaje = LoginResponse.textOnError, exception = exception.message))
        }
    }
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this@module::class.java.classLoader, "templates")
    }
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            // Configure Gson here
        }
    }


    val homeService: HomeService by inject()
    val loginService: LoginService by inject()

    routing {

        get("/") {
            //  Entrada a la pagina, supongo que debería mandarte al home o a la sala si el cache te tiene todavía
            call.respondRedirect("/ui/home")
        }
        route("/ui") {
            homeView(homeService)
        }
        homeContoller(homeService)
        loginContoller(loginService)


        route("/api") {
            authenticate {
                get("/empresa") {
                    val principal = call.principal<UserIdPrincipal>() ?: error("No principal")
                    call.respond(principal.name)
//                call.respondRedirect("/static/ktor_logo.svg",false)
                }
            }
        }
        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }
    }
}

fun FlowOrMetaDataContent.styleCss(builder: CSSBuilder.() -> Unit) {
    style(type = ContentType.Text.CSS.toString()) {
        +CSSBuilder().apply(builder).toString()
    }
}

fun CommonAttributeGroupFacade.style(builder: CSSBuilder.() -> Unit) {
    this.style = CSSBuilder().apply(builder).toString().trim()
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}