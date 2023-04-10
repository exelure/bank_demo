package denis.nesterov.demo.microservices.accounts.model

import java.time.LocalDate

data class CardDto(
    var cardId: Long?,
    var customerId: Long?,
    var number: String?,
    var type: String?,
    var limitAmount: Int?,
    var usedAmount: Int?,
    var availableAmount: Int?,
    var createDt: LocalDate?,
)