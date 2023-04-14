package denis.nesterov.demo.microservices.loans.controller

import denis.nesterov.demo.microservices.loans.configuration.properties.HeaderNames
import denis.nesterov.demo.microservices.loans.configuration.properties.LoansServiceConfig
import denis.nesterov.demo.microservices.loans.model.CustomerDto
import denis.nesterov.demo.microservices.loans.model.LoanDto
import denis.nesterov.demo.microservices.loans.model.Properties
import denis.nesterov.demo.microservices.loans.repository.LoansRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class LoansController {

    private val log = LoggerFactory.getLogger(LoansController::class.java)

    @Autowired
    private lateinit var loansRepository: LoansRepository

    @Autowired
    private lateinit var config: LoansServiceConfig

    @PostMapping("/loans")
    fun loansDetails(
        @RequestHeader(HeaderNames.CORR_ID) correlationId: String?,
        @RequestBody customerDto: CustomerDto,
    ): List<LoanDto> {
        log.info("Method loansDetails started")

        val result = loansRepository.findByCustomerIdOrderByStartDtDesc(customerDto.id)
            .map { LoanDto.fromEntity(it) }

        log.info("Method loansDetails ended")
        return result
    }

    @GetMapping("/loans/properties")
    fun loansDetails() = Properties(
        buildVersion = config.buildVersion,
        msg = config.msg,
        activeBranches = config.activeBranches,
        mailDetails = config.mailDetails
    )
}
