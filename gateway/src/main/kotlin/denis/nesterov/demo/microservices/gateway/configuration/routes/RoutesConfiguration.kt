package denis.nesterov.demo.microservices.gateway.configuration.routes

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.Date

@Configuration
class RoutesConfiguration {

    @Bean
    fun routesLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .accountsCustomRoute()
            .loansCustomRoute()
            .cardsCustomRoute()
            .build()
    }

    private fun RouteLocatorBuilder.Builder.accountsCustomRoute() = route {
        it.path("/demobank/accounts/**")
        .filters { f -> f
            .rewritePath("/demobank/accounts/(?<segment>.*)", "/\${segment}")
            .addResponseHeader("X-Response-Time", Date().toString())
        }.uri("lb://ACCOUNTS")
    }

    private fun RouteLocatorBuilder.Builder.loansCustomRoute() = route {
        it.path("/demobank/loans/**")
        .filters { f -> f
            .rewritePath("/demobank/loans/(?<segment>.*)", "/\${segment}")
            .addResponseHeader("X-Response-Time", Date().toString())
        }.uri("lb://LOANS")
    }

    private fun RouteLocatorBuilder.Builder.cardsCustomRoute() = route {
        it.path("/demobank/cards/**")
        .filters { f -> f
            .rewritePath("/demobank/cards/(?<segment>.*)", "/\${segment}")
            .addResponseHeader("X-Response-Time", Date().toString())
        }.uri("lb://CARDS")
    }

}
