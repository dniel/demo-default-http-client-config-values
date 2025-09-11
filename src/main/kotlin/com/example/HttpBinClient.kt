package no.vy.trafficinfo.trainroute.clients

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("httpbin")
interface HttpBinClient {

    @Get("/get")
    suspend fun get(): String
}
