package no.vy.trafficinfo.trainroute.clients

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("httpbin")
interface HttpClientClient {
    @Get("/get")
    suspend fun get(): String
}
