package denis.nesterov.demo.microservices.loans.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "loans")
@ConstructorBinding
data class LoansServiceConfig(
    val buildVersion: String,
    val msg: String,
    val activeBranches: List<String>,
    val mailDetails: Map<String, String>,
)
