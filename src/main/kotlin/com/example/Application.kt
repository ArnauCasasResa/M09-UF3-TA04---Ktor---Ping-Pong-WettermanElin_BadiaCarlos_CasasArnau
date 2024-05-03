package com.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.util.*

@OptIn(InternalAPI::class)
suspend fun main() {
    val client = HttpClient(CIO)

    client.post("http://127.0.0.1:8080/message") {
        body = "Ping"
    }
    println("Mensaje enviado: Ping")

    val messageResponse = client.get("http://127.0.0.1:8080/message")
    val message = messageResponse.body<String>()
    println("Mensaje recibido: $message")

    client.close()
}

