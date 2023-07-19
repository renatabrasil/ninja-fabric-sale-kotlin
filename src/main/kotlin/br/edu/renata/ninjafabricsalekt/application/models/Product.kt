package br.edu.renata.ninjafabricsalekt.application.models

import java.time.ZonedDateTime
import java.util.*

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val fabric: Fabric,
    val quantity: Int,
    val updatedAt: ZonedDateTime,
    val updatedBy: String
)
