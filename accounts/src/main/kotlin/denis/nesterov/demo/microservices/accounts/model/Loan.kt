package denis.nesterov.demo.microservices.accounts.model

import java.time.LocalDate

data class LoanDto(
    var loanNumber: Long?,
    var customerId: Long?,
    var startDt: LocalDate?,
    var type: String?,
    var totalAmount: Int?,
    var paidAmount: Int?,
    var outstandingAmount: Int?,
    var createDt: LocalDate?,
)