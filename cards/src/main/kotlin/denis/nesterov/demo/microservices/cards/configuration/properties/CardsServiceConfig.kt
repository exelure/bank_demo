package denis.nesterov.demo.microservices.cards.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "cards")
@ConstructorBinding
data class CardsServiceConfig(
    val buildVersion: String?,
    val msg: String?,
    val activeBranches: List<String> = emptyList(),
    val mailDetails: Map<String, String> = emptyMap(),
)
