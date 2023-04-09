package denis.nesterov.demo.microservices.accounts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@ConfigurationPropertiesScan
@RefreshScope
class AccountsApplication

fun main(args: Array<String>) {
	runApplication<AccountsApplication>(*args)
}
