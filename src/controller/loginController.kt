package com.federico.d.bernst.controller

import com.federico.d.bernst.controller.received.LoginReceived
import com.federico.d.bernst.controller.service.LoginService
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.post

fun Routing.loginContoller(loginService: LoginService) {
    post("/login") {
        val response = call.receive<LoginReceived>()
        call.respond(loginService.login(response.username, response.password))
    }
}
