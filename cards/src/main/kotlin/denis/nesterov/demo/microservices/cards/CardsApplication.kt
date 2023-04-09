package denis.nesterov.demo.microservices.cards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@ConfigurationPropertiesScan
class CardsApplication

fun main(args: Array<String>) {
	runApplication<CardsApplication>(*args)
}
