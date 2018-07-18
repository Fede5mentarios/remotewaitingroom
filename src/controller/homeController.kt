package com.federico.d.bernst.controller

import com.federico.d.bernst.controller.service.HomeService
import com.federico.d.bernst.security.UserSession
import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.sessions.sessions

fun Routing.homeContoller(homeService: HomeService) {
    get("/") {
        call.respond(homeService.getEmpresas())
    }
    authenticate {
        post("/logout") {
            call.sessions.clear(UserSession.sessionName)
            call.respondRedirect("/")
        }
    }
}
