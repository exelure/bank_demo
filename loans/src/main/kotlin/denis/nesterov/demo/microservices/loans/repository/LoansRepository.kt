package denis.nesterov.demo.microservices.loans.repository

import denis.nesterov.demo.microservices.loans.model.LoanEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LoansRepository : CrudRepository<LoanEntity, Long> {

    fun findByCustomerIdOrderByStartDtDesc(customerId: Long?): List<LoanEntity>
}
