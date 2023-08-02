package br.edu.renata.ninjafabricsalekt.presentation.controllers.employees.requests

import br.edu.renata.ninjafabricsalekt.application.models.Employee
import java.time.ZonedDateTime

data class CreateEmployeeRequest(
    val name: String,
    val role: String,
    val admissionDate: ZonedDateTime = ZonedDateTime.now(),
    val resignationDate: ZonedDateTime? = null
) {
    fun toDomain() = Employee(
        name = name,
        role = Employee.Role.valueOf(role.uppercase()).name,
        admissionDate = admissionDate,
        resignationDate = resignationDate
    )

}
