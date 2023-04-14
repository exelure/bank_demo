package denis.nesterov.demo.microservices.loans.model

import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "loans")
data class LoanEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_number")
    var loanNumber: Long,

    @Column(name = "customer_id")
    var customerId: Long,

    @Column(name = "start_dt")
    var startDt: LocalDate,

    @Column(name = "type")
    var type: String,

    @Column(name = "total_amount")
    var totalAmount: Int,

    @Column(name = "paid_amount")
    var paidAmount: Int,

    @Column(name = "outstanding_amount")
    var outstandingAmount: Int,

    @Column(name = "create_dt")
    var createDt: LocalDate,

    )

data class LoanDto(
    var loanNumber: Long?,
    var customerId: Long?,
    var startDt: LocalDate?,
    var type: String?,
    var totalAmount: Int?,
    var paidAmount: Int?,
    var outstandingAmount: Int?,
    var createDt: LocalDate?,
    ) {
    companion object {
        fun fromEntity(entity: LoanEntity?) = LoanDto(
            loanNumber = entity?.loanNumber,
            customerId = entity?.customerId,
            startDt = entity?.startDt,
            type = entity?.type,
            totalAmount = entity?.totalAmount,
            paidAmount = entity?.paidAmount,
            outstandingAmount = entity?.outstandingAmount,
            createDt = entity?.createDt,
        )
    }
}