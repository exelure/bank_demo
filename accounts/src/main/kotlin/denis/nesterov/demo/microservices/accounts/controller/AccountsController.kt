package denis.nesterov.demo.microservices.accounts.controller

import denis.nesterov.demo.microservices.accounts.configuration.properties.AccountsServiceConfig
import denis.nesterov.demo.microservices.accounts.configuration.properties.HeaderNames
import denis.nesterov.demo.microservices.accounts.model.AccountDto
import denis.nesterov.demo.microservices.accounts.model.CustomerDetails
import denis.nesterov.demo.microservices.accounts.model.CustomerDto
import denis.nesterov.demo.microservices.accounts.model.Properties
import denis.nesterov.demo.microservices.accounts.repository.AccountsRepository
import denis.nesterov.demo.microservices.accounts.service.client.CardsFeignClient
import denis.nesterov.demo.microservices.accounts.service.client.LoansFeignClient
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import io.github.resilience4j.retry.annotation.Retry
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountsController {

    private val log = LoggerFactory.getLogger(AccountsController::class.java)

    @Autowired
    private lateinit var accountsRepository: AccountsRepository

    @Autowired
    private lateinit var config: AccountsServiceConfig

    @Autowired
    private lateinit var cardsClient: CardsFeignClient

    @Autowired
    private lateinit var loansClient: LoansFeignClient

    @PostMapping("/account")
    fun accountDetails(@RequestBody customerDto: CustomerDto): AccountDto {
        return AccountDto.fromEntity(accountsRepository.findByCustomerId(customerDto.id))
    }

    @GetMapping("/account/properties")
    fun accountProperties() = Properties(
        buildVersion = config.buildVersion,
        msg = config.msg,
        activeBranches = config.activeBranches,
        mailDetails = config.mailDetails
    )

    @PostMapping("/account/details")
    @CircuitBreaker(name = "accountDetailsCircuit", fallbackMethod = "accountDetailsFallback")
    @Retry(name = "accountDetailsRetry", fallbackMethod = "accountDetailsFallback")
    fun getAccountDetails(
        @RequestHeader(HeaderNames.CORR_ID) correlationId: String,
        @RequestBody customerDto: CustomerDto,
    ): CustomerDetails {
        val account = AccountDto.fromEntity(accountsRepository.findByCustomerId(customerDto.id))
        val loans = loansClient.getLoansDetails(correlationId, customerDto)
        val cards = cardsClient.getCardsDetails(correlationId, customerDto)

        return CustomerDetails(account = account, loans = loans, cards = cards)
    }

    private fun accountDetailsFallback(correlationId: String, customerDto: CustomerDto, t: Throwable): CustomerDetails {
        log.info("Used fallback method for account details (corr-id: $correlationId)")

        val account = AccountDto.fromEntity(accountsRepository.findByCustomerId(customerDto.id))
        return CustomerDetails(account = account, loans = emptyList(), cards = emptyList())
    }

    @GetMapping("/account/test")
    @RateLimiter(name = "accountTestRateLimiter", fallbackMethod = "accountTestFallback")
    fun getAccountTest(@RequestBody customerDto: CustomerDto): String {
        return "Hello, ${customerDto.name}, welcome to DemoBank!"
    }

    private fun accountTestFallback(@RequestBody customerDto: CustomerDto): String {
        return "Hi, ${customerDto.name}, sorry, but you've made too many requests!"
    }

}
