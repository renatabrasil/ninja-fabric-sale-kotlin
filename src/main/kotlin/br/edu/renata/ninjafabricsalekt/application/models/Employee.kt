package br.edu.renata.ninjafabricsalekt.application.models

import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Employee(
    @Id
    val id: String? = UUID.randomUUID().toString(),
    val name: String,
    val role: String,
    val active: Boolean = true,
    @Column(name = "admission_date", nullable = false)
    val admissionDate: ZonedDateTime,
    @Column(name = "resignation_date")
    val resignationDate: ZonedDateTime?
) {
    enum class Role {
        SELLER,
        MANAGEMENT,
        VIEWER;
    }

}
