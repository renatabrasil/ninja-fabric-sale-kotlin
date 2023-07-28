package br.edu.renata.ninjafabricsalekt.application.models

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.*

@Entity(name = "orders")
data class Order(
    @Id
    val id: String? = null ?: UUID.randomUUID().toString(),
    @Transient
    var productItems: List<ProductItem>,

    @OneToOne(cascade = [CascadeType.ALL])
    val customer: Customer,
    var status: Status,
    @Column(name = "seller")
    val seller: String,

    @Transient
    @Column(name = "shipping_modality")
    val shippingModality: ShippingModality,

    @Transient
    @Column(name = "cash_payment_type")
    val cashPaymentType: PaymentType,

    val observation: String = "",
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    val createdAt: ZonedDateTime? = null,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: ZonedDateTime? = null
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

    fun updateOrderItems(productItems: List<ProductItem>) {
        this.productItems = productItems
    }

    fun updateStatus(status: Order.Status) {
        this.status = status

    }

}