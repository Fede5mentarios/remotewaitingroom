package com.federico.d.bernst.controller

import com.federico.d.bernst.controller.service.HomeService
import com.federico.d.bernst.dagger.AplicationComponent
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import org.koin.ktor.ext.inject

fun Routing.homeContoller(homeService: HomeService) {
    get("/") {
        call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
//                call.respond(homeService.getEmpresas())
    }
}
