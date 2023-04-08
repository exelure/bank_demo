package denis.nesterov.demo.microservices.accounts.model

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class CustomerEntity(

    @Id
    @Column(name = "id")
    var id: Long,

    @Column(name = "name")
    var name: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "mobile_number")
    var mobileNumber: String,

    @Column(name = "create_dt")
    var createDt: LocalDate,

    )

data class CustomerDto(
    var id: Long?,
    var name: String?,
    var email: String?,
    var mobileNumber: String?,
    var createDt: LocalDate?,
    ) {
    companion object {
        fun fromEntity(entity: CustomerEntity?) = CustomerDto(
            id = entity?.id,
            name = entity?.name,
            email = entity?.email,
            mobileNumber = entity?.mobileNumber,
            createDt = entity?.createDt,
        )
    }
}
