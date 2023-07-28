package br.edu.renata.ninjafabricsalekt.helpers

import br.edu.renata.ninjafabricsalekt.application.models.Customer
import br.edu.renata.ninjafabricsalekt.application.models.Order
import br.edu.renata.ninjafabricsalekt.presentation.controllers.orders.request.CreateOrderRequest
import org.jeasy.random.EasyRandom
import java.time.ZonedDateTime
import java.util.*

fun getCreateOrderRequest(
    productItems: List<Order.ProductItem> = emptyList(),
    customer: Customer = EasyRandom().nextObject(Customer::class.java),
    seller: String = "Joãozinho Trinta",
    shippingModality: Order.ShippingModality = Order.ShippingModality.CIF,
    cashPaymentType: Order.PaymentType = Order.PaymentType.IN_CASH,
    observation: String = ""
) =
    CreateOrderRequest(
        productItems = productItems,
        customer = customer,
        seller = seller,
        shippingModality = shippingModality,
        cashPaymentType = cashPaymentType,
        observation = observation
    )

fun getDummyOrder(
    id: String = UUID.randomUUID().toString(),
    seller: String = "José",
    productItems: List<Order.ProductItem> = emptyList(),
    status: Order.Status = Order.Status.CREATED,
    observation: String = "",
    shippingModality: Order.ShippingModality = Order.ShippingModality.CIF,
    cashPaymentType: Order.PaymentType = Order.PaymentType.IN_CASH,
    customer: Customer = EasyRandom().nextObject(Customer::class.java).copy(id = UUID.randomUUID().toString())
) =
    Order(
        id = id,
        seller = seller,
        productItems = productItems,
        customer = customer,
        status = status,
        shippingModality = shippingModality,
        cashPaymentType = cashPaymentType,
        observation = observation,
        createdAt = ZonedDateTime.now(),
        updatedAt = ZonedDateTime.now()
    )