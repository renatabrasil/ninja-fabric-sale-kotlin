package br.edu.renata.ninjafabricsalekt.application.domain

import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities.EmployeeEntity
import java.time.ZonedDateTime

data class Employee(
    val id: String? = null,
    val name: String,
    val office: String,
    val admissionDate: ZonedDateTime = ZonedDateTime.now(),
    val resignationDate: ZonedDateTime?,
    val active: Boolean? = true

) {
    fun toEntity() = EmployeeEntity(
        name = name,
        office = office,
        admissionDate = admissionDate,
        resignationDate = resignationDate,
        active = active!!

    )

}
