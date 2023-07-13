package br.edu.renata.ninjafabricsalekt.adapters.inbound.web.employees.requests

import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities.EmployeeEntity
import br.edu.renata.ninjafabricsalekt.application.domain.Employee
import java.time.ZonedDateTime

data class CreateEmployeeRequest(
    val name: String,
    val office: String,
    val admissionDate: ZonedDateTime = ZonedDateTime.now(),
    val resignationDate: ZonedDateTime? = null
) {
    fun toDomain() = Employee(
        name = name,
        office = office,
        admissionDate = admissionDate,
        resignationDate = resignationDate
    )

}
