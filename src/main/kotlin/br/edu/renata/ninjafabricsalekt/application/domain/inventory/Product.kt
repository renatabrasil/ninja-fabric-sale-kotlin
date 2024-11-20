package br.edu.renata.ninjafabricsalekt.application.domain.inventory

import br.edu.renata.ninjafabricsalekt.application.domain.management.Fabric
import java.time.ZonedDateTime
import java.util.*

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val fabric: Fabric,
    val quantity: Int,
    val updatedAt: ZonedDateTime,
    val updatedBy: String
)
