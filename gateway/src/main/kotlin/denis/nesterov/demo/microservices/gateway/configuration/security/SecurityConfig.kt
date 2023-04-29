package denis.nesterov.demo.microservices.gateway.configuration.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun springWebSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http.authorizeExchange { exchanges -> exchanges
                .pathMatchers("/demobank/accounts/**").authenticated()
                .pathMatchers("/demobank/cards/**").authenticated()
                .pathMatchers("/demobank/loans/**").permitAll()
        }.oauth2ResourceServer().jwt()

        http.csrf().disable()

        return http.build()
    }

}
