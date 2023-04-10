package denis.nesterov.demo.microservices.accounts.model

data class CustomerDetails(
    val account: AccountDto,
    val loans: List<LoanDto>,
    val cards: List<CardDto>,
)
