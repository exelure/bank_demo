package denis.nesterov.demo.microservices.loans.controller

import denis.nesterov.demo.microservices.loans.configuration.properties.LoansServiceConfig
import denis.nesterov.demo.microservices.loans.model.CustomerDto
import denis.nesterov.demo.microservices.loans.model.LoanDto
import denis.nesterov.demo.microservices.loans.model.Properties
import denis.nesterov.demo.microservices.loans.repository.LoansRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoansController {

    @Autowired
    private lateinit var loansRepository: LoansRepository

    @Autowired
    private lateinit var config: LoansServiceConfig

    @PostMapping("/loans")
    fun loansDetails(@RequestBody customerDto: CustomerDto): List<LoanDto> {
        return loansRepository.findByCustomerIdOrderByStartDtDesc(customerDto.id)
            .map { LoanDto.fromEntity(it) }
    }

    @GetMapping("/loans/properties")
    fun loansDetails() = Properties(
        buildVersion = config.buildVersion,
        msg = config.msg,
        activeBranches = config.activeBranches,
        mailDetails = config.mailDetails
    )
}
