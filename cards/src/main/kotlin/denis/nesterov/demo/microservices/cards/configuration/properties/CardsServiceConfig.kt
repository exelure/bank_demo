package denis.nesterov.demo.microservices.cards.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "cards")
data class CardsServiceConfig @ConstructorBinding constructor(
    val buildVersion: String?,
    val msg: String?,
    val activeBranches: List<String> = emptyList(),
    val mailDetails: Map<String, String> = emptyMap(),
)
