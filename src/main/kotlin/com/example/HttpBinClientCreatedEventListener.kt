package no.vy.trafficinfo.trainroute.clients

import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import io.micronaut.http.client.HttpClientConfiguration
import jakarta.inject.Named
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class HttpClientBeanCreatorListener(
    @Named("httpbin") private val cfg: HttpClientConfiguration,
) : BeanCreatedEventListener<HttpClientClient> {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun onCreated(event: BeanCreatedEvent<HttpClientClient>): HttpClientClient {
        val bean = event.bean

        log.error("###OpPointClientListener###Bean of type OperationalPointClient has been created!")
        log.error("###Config for 'operational-point':")
        log.error("###  connectTimeout = ${cfg.connectTimeout}")
        log.error("###  readTimeout = ${cfg.readTimeout}")
        log.error("###  pool config isEnabled  = ${cfg.connectionPoolConfiguration.isEnabled}")
        log.error("###  pool config 1  = ${cfg.connectionPoolConfiguration.maxConcurrentHttp2Connections}")
        log.error("###  pool config 2  = ${cfg.connectionPoolConfiguration.maxConcurrentRequestsPerHttp2Connection}")
        log.error("###  pool config 3  = ${cfg.connectionPoolConfiguration.connectionLocality}")

        return bean
    }
}