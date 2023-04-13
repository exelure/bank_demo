package denis.nesterov.demo.microservices.gateway.filter.tracing

import denis.nesterov.demo.microservices.gateway.configuration.properties.HeaderNames
import denis.nesterov.demo.microservices.gateway.filter.FilterUtility
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
@Order(1)
class CorrIdRequestTraceFilter : GlobalFilter {

    private val log = LoggerFactory.getLogger(CorrIdRequestTraceFilter::class.java)

    @Autowired
    private lateinit var filterUtility: FilterUtility

    override fun filter(exch: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        val correlationId = exch.request.headers[HeaderNames.CORR_ID]
            ?.get(0)
            ?: filterUtility.generateCorrelationId()

        log.debug("Detected correlation-id in tracing filter: $correlationId")

        val exchange = filterUtility.setRequestCorrelationId(exch, correlationId)
        return chain.filter(exchange)
    }

}
