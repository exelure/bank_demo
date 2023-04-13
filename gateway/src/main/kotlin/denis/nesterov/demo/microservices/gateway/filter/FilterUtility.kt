package denis.nesterov.demo.microservices.gateway.filter

import denis.nesterov.demo.microservices.gateway.configuration.properties.HeaderNames
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import java.util.*

@Component
class FilterUtility {

    fun generateCorrelationId(): String = UUID.randomUUID().toString()

    fun setRequestCorrelationId(exchange: ServerWebExchange, correlationId: String): ServerWebExchange {
        return exchange.mutate().request(
            exchange.request.mutate().header(HeaderNames.CORR_ID, correlationId).build()
        ).build()
    }

}
