package no.vy.trafficinfo.trainroute.clients

import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import io.micronaut.http.client.HttpClientConfiguration
import jakarta.inject.Named
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class HttpBinClientCreatedEventListener(
    @Named("httpbin") private val cfg: HttpClientConfiguration,
) : BeanCreatedEventListener<HttpBinClient> {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun onCreated(event: BeanCreatedEvent<HttpBinClient>): HttpBinClient {
        val bean = event.bean

        log.info("###HttpBinClientCreatedEventListener###Bean of type HttpBinClient has been created!")
        log.info("###Config for 'HttpBinClient':")
        log.info("###  connectTimeout = ${cfg.connectTimeout}")
        log.info("###  readTimeout = ${cfg.readTimeout}")
        log.info("###  pool config isEnabled  = ${cfg.connectionPoolConfiguration.isEnabled}")
        log.info("###  pool config maxConcurrentHttp2Connections  = ${cfg.connectionPoolConfiguration.maxConcurrentHttp2Connections}")
        log.info("###  pool config maxConcurrentRequestsPerHttp2Connection  = ${cfg.connectionPoolConfiguration.maxConcurrentRequestsPerHttp2Connection}")
        log.info("###  pool config connectionLocality  = ${cfg.connectionPoolConfiguration.connectionLocality}")

        return bean
    }
}