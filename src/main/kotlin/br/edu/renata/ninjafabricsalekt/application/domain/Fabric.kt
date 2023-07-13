package br.edu.renata.ninjafabricsalekt.application.domain

import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities.FabricEntity
import java.time.ZonedDateTime

data class Fabric(
    val id: String?,
    val name: String,
    val description: String?,
    val code: String?,
    val createdAt: ZonedDateTime?,
    val updatedAt: ZonedDateTime?
) {
    fun toEntity() = FabricEntity(
        id = id,
        name = name,
        description = description,
        code = code,
        createdAt = createdAt,
        updatedAt = updatedAt

    )

}