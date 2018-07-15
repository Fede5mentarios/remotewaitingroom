package com.federico.d.bernst

import com.federico.d.bernst.controller.homeContoller
import com.federico.d.bernst.controller.service.HomeService
import com.federico.d.bernst.koin.persistenseModule
import com.federico.d.bernst.koin.serviceModule
import com.federico.d.bernst.view.homeView
import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.content.resources
import io.ktor.content.static
import io.ktor.features.CallLogging
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.routing
import kotlinx.css.CSSBuilder
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.FlowOrMetaDataContent
import kotlinx.html.style
import org.koin.ktor.ext.inject
import org.koin.standalone.StandAloneContext.startKoin

fun main(args: Array<String>): Unit = io.ktor.server.netty.DevelopmentEngine.main(args)

fun Application.module() {

    //	Features
    install(Authentication) {}
    install(CallLogging)

    startKoin(listOf(persistenseModule, serviceModule))

    val homeService: HomeService by inject()
    routing {
        //	UI
        homeView()

        //	APIs
        homeContoller(homeService)

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