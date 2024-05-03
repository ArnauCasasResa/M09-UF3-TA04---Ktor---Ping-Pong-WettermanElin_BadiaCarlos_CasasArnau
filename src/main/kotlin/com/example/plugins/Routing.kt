package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val server = embeddedServer(Netty, port = 8080) {


        routing {
            post("/message") {
                // Manejador para la solicitud POST
                val message = call.receive<String>()
                call.respondText("Mensaje recibido: $message")
            }

            get("/message") {
                // Manejador para la solicitud GET
                call.respondText("Ping")
            }
        }
    }
    server.start(wait = true)
}
