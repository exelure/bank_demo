package denis.nesterov.demo.microservices.cards.model

import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "cards")
data class CardEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "customer_id")
    var customerId: Long,

    @Column(name = "number")
    var number: String,

    @Column(name = "type")
    var type: String,

    @Column(name = "limit_amount")
    var limitAmount: Int,

    @Column(name = "used_amount")
    var usedAmount: Int,

    @Column(name = "available_amount")
    var availableAmount: Int,

    @Column(name = "create_dt")
    var createDt: LocalDate,

    )

data class CardDto(
    var cardId: Long?,
    var customerId: Long?,
    var number: String?,
    var type: String?,
    var limitAmount: Int?,
    var usedAmount: Int?,
    var availableAmount: Int?,
    var createDt: LocalDate?,
    ) {
    companion object {
        fun fromEntity(entity: CardEntity?) = CardDto(
            cardId = entity?.id,
            customerId = entity?.customerId,
            number = entity?.number,
            type = entity?.type,
            limitAmount = entity?.limitAmount,
            usedAmount = entity?.usedAmount,
            availableAmount = entity?.availableAmount,
            createDt = entity?.createDt
        )
    }
}
