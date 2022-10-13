package com.guiparpineli.plugins

import com.guiparpineli.routes.customerRouting
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
       customerRouting()
    }
}
