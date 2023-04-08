package denis.nesterov.demo.microservices.cards.repository

import denis.nesterov.demo.microservices.cards.model.CardEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CardsRepository : CrudRepository<CardEntity, Long> {

    fun findByCustomerId(customerId: Long?): List<CardEntity>
}