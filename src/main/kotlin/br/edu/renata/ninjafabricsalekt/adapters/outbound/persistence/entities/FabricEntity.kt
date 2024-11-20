package br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities

import br.edu.renata.ninjafabricsalekt.application.domain.management.Fabric
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class FabricEntity(
    @Id
    val id: String?,

    val name: String,

    val description: String?,
    val code: String?,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    val createdAt: ZonedDateTime?,

    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: ZonedDateTime?

) {
    fun toDomain() = Fabric(
        id = id,
        name = name,
        description = description,
        code = code,
        createdAt = createdAt,
        updatedAt = updatedAt

    )

}