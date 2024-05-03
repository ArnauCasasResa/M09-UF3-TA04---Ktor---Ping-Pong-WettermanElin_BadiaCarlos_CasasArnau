package com.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.util.*
import java.util.*

@OptIn(InternalAPI::class)
suspend fun main() {
    val client = HttpClient(CIO)
    val scan= Scanner(System.`in`)
    println("Escribe un mensaje:")
    val msgEnvi=scan.nextLine()
    client.post("http://127.0.0.1:8080/message") {
        body = msgEnvi
    }
    println("Mensaje enviado: $msgEnvi")

    val messageResponse = client.get("http://127.0.0.1:8080/message")
    val message = messageResponse.body<String>()
    println("Mensaje recibido: $message")

    client.close()
}

