package br.edu.renata.ninjafabricsalekt.presentation.controllers.orders.request

import br.edu.renata.ninjafabricsalekt.application.models.Customer
import br.edu.renata.ninjafabricsalekt.application.models.Order

data class CreateOrderRequest(
    val productItems: List<Order.ProductItem>,
    val customer: Customer,
    val seller: String,
    val shippingModality: Order.ShippingModality,
    val cashPaymentType: Order.PaymentType,
    val observation: String = ""
) {
    fun toDomain() = Order(
        id = null,
        productItems = productItems,
        customer = customer,
        seller = seller,
        shippingModality = shippingModality.name,
        cashPaymentType = cashPaymentType.name,
        observation = observation,
        status = Order.Status.CREATED.name
    )

}
