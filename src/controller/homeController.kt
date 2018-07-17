package com.federico.d.bernst.controller

import com.federico.d.bernst.controller.service.HomeService
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.homeContoller(homeService: HomeService) {
    get("/") {
        call.respond(homeService.getEmpresas())
    }
}
