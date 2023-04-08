package denis.nesterov.demo.microservices.accounts.controller

import denis.nesterov.demo.microservices.accounts.model.AccountDto
import denis.nesterov.demo.microservices.accounts.model.CustomerDto
import denis.nesterov.demo.microservices.accounts.repository.AccountsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountsController {

    @Autowired
    private lateinit var accountsRepository: AccountsRepository

    @PostMapping("/account")
    fun accountDetails(@RequestBody customerDto: CustomerDto): AccountDto {
        return AccountDto.fromEntity(accountsRepository.findByCustomerId(customerDto.id))
    }
}