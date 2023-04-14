package denis.nesterov.demo.microservices.accounts.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "accounts")
data class AccountsServiceConfig @ConstructorBinding constructor(
    val buildVersion: String?,
    val msg: String?,
    val activeBranches: List<String> = emptyList(),
    val mailDetails: Map<String, String> = emptyMap(),
)
