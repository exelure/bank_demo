package denis.nesterov.demo.microservices.cards.model

data class Properties(
    val buildVersion: String,
    val msg: String,
    val activeBranches: List<String>,
    val mailDetails: Map<String, String>,
)
