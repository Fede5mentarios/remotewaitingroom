package com.federico.d.bernst.controller

import com.federico.d.bernst.controller.received.LoginReceived
import com.federico.d.bernst.controller.service.LoginService
import com.federico.d.bernst.security.UserSession
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.post
import io.ktor.sessions.sessions
import io.ktor.sessions.set

fun Routing.loginContoller(loginService: LoginService) {
    post("/login") {
        val response = call.receive<LoginReceived>()
        val result = loginService.login(response.username, response.password)
        call.sessions.set(UserSession(result.token))
        call.respond(result)
    }
}
