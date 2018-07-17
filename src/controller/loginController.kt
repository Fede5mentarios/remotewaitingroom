package com.federico.d.bernst.controller

import com.federico.d.bernst.controller.service.LoginService
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.loginContoller(loginService: LoginService) {
    get("/login") {
        call.respond(loginService.authToken("","")) //TODO
    }
}
