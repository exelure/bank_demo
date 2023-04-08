package denis.nesterov.demo.microservices.accounts.repository

import denis.nesterov.demo.microservices.accounts.model.AccountEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountsRepository : CrudRepository<AccountEntity, Long> {

    fun findByCustomerId(customerId: Long?): AccountEntity?
}