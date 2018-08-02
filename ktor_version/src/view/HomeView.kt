package com.federico.d.bernst.view

import com.federico.d.bernst.controller.service.HomeService
import io.ktor.application.call
import io.ktor.html.PlaceholderList
import io.ktor.html.each
import io.ktor.html.insert
import io.ktor.html.respondHtml
import io.ktor.routing.Route
import io.ktor.routing.get
import kotlinx.html.*

fun Route.homeView(homeService: HomeService) {

    get("/home") {
        val empresas = homeService.getEmpresas()
        val list = PlaceholderList<UL, FlowContent>()
        call.respondHtml {
            head {
                title { +"Async World" }
            }
            body(classes = "/home.css") {
                h1("title") {
                    +"Title"
                }
                ul {
                    each(list as "$ empresas ") {
                    li {
                        insert(it)
                    }
                }
                }

                div {
                    onClick = ""
                }
            }
        }

    }
}