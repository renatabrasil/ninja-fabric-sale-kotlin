package br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities

import br.edu.renata.ninjafabricsalekt.application.domain.management.Employee
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.*

@Entity
data class EmployeeEntity(
    @Id
//    @GeneratedValue(strategy = GenerationType.)
    val id: String? = UUID.randomUUID().toString(),

    val name: String,

    val office: String,

    val active: Boolean = true,

    @Column(name = "admission_date", nullable = false)
    val admissionDate: ZonedDateTime,

    @Column(name = "resignation_date")
    val resignationDate: ZonedDateTime?

) {
    fun toDomain() = Employee(
        id = id,
        name = name,
        office = office,
        admissionDate = admissionDate,
        resignationDate = resignationDate,
        active = active
    )

    fun Iterable<EmployeeEntity>.toDomain(): List<Employee> = this.map { it.toDomain() }

}
