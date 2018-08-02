package com.federico.d.bernst.controller

import com.federico.d.bernst.controller.service.HomeService
import com.federico.d.bernst.security.UserSession
import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.sessions.sessions

fun Route.homeContoller(homeService: HomeService) {
    route("/ui") {
        get("/home") {
            call.respond(FreeMarkerContent("/home.ftl",
                    mapOf("empresa" to homeService.getEmpresas()), "e"))
        }
    }
    route("/api") {
        get("/home") {
            call.respond(homeService.getEmpresas())
        }
        authenticate {
            post("/logout") {
                call.sessions.clear(UserSession.sessionName)
                call.respondRedirect("/")
            }
        }
    }
}
