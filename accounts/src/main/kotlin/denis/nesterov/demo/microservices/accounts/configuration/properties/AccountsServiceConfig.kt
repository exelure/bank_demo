package denis.nesterov.demo.microservices.accounts.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "accounts")
@ConstructorBinding
data class AccountsServiceConfig(
    val buildVersion: String,
    val msg: String,
    val activeBranches: List<String>,
    val mailDetails: Map<String, String>,
)
