package denis.nesterov.demo.microservices.accounts.controller

import denis.nesterov.demo.microservices.accounts.configuration.properties.AccountsServiceConfig
import denis.nesterov.demo.microservices.accounts.model.AccountDto
import denis.nesterov.demo.microservices.accounts.model.CustomerDto
import denis.nesterov.demo.microservices.accounts.model.Properties
import denis.nesterov.demo.microservices.accounts.repository.AccountsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountsController {

    @Autowired
    private lateinit var accountsRepository: AccountsRepository

    @Autowired
    private lateinit var config: AccountsServiceConfig

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

}
