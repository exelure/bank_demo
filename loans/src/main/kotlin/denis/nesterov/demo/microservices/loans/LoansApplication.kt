package denis.nesterov.demo.microservices.loans

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@ConfigurationPropertiesScan
class LoansApplication

fun main(args: Array<String>) {
	runApplication<LoansApplication>(*args)
}
