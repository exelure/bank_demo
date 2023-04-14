package denis.nesterov.demo.microservices.accounts.model

import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "accounts")
data class AccountEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    var accountNumber: Long,

    @Column(name = "customer_id")
    var customerId: Long,

    @Column(name = "type")
    var type: String,

    @Column(name = "branch_address")
    var branchAddress: String,

    @Column(name = "create_dt")
    var createDt: LocalDate,

    )

data class AccountDto(
    var accountNumber: Long?,
    var customerId: Long?,
    var type: String?,
    var branchAddress: String?,
    var createDt: LocalDate?,
    ) {
    companion object {
        fun fromEntity(entity: AccountEntity?) = AccountDto(
            accountNumber = entity?.accountNumber,
            customerId = entity?.customerId,
            type = entity?.type,
            branchAddress = entity?.branchAddress,
            createDt = entity?.createDt
        )
    }
}