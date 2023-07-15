package br.edu.renata.ninjafabricsalekt.application.domain.orders

import br.edu.renata.ninjafabricsalekt.application.domain.Color
import br.edu.renata.ninjafabricsalekt.application.domain.management.Fabric
import java.math.BigDecimal
import java.util.*

data class Order(
    val id: String = UUID.randomUUID().toString(),
    val productItems: List<ProductItem>,
    val customer: Customer,
    val status: Status,
    val seller: String,
    val shippingModality: ShippingModality,
    val cashPaymentType: PaymentType,
    val observation: String = ""
) {
    data class ProductItem(
        val fabric: Fabric,
        val color: Color,
        val unitPrice: BigDecimal,
        val quantity: Int,
        val unitMeasurement: UnitMeasurement
    )

    enum class UnitMeasurement {
        METER,
        ROLL
    }

    enum class Status {
        CREATED,
        CONFIRMED,
        IN_PROGRESS,
        IN_DELIVERING,
        CANCELLED,
        FINISHED
    }

    enum class ShippingModality(val description: String) {
        CIF("Customer paid"),
        FOB("Payed by the supplier")
    }

    enum class PaymentType {
        IN_CASH,
        _30_60_90
    }

}