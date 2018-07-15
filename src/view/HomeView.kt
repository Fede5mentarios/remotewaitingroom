package com.federico.d.bernst.view

import com.federico.d.bernst.respondCss
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.Routing
import io.ktor.routing.get
import kotlinx.css.Color
import kotlinx.css.body
import kotlinx.css.em
import kotlinx.css.p
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.li
import kotlinx.html.ul

fun Routing.homeView() {

    get("/home") {
        call.respondHtml {
            body {
                h1 { +"HTML" }
                ul {
                    for (n in 1..10) {
                        li { +"$n" }
                    }
                }
            }
        }
    }

    get("/styles.css") {
        call.respondCss {
            body {
                backgroundColor = Color.red
            }
            p {
                fontSize = 2.em
            }
            rule("p.myclass") {
                color = Color.blue
            }
        }
    }
}
