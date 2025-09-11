package com.example

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.Micronaut.run
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*
import jakarta.inject.Singleton
import no.vy.trafficinfo.trainroute.clients.HttpBinClient

@OpenAPIDefinition(
    info =
        Info(
            title = "demo",
            version = "0.0",
        ),
)
@Singleton
object Api

suspend fun main(args: Array<String>) {
    val context: ApplicationContext = run(*args)
    val httpbinClient = context.getBean(HttpBinClient::class.java)
}
