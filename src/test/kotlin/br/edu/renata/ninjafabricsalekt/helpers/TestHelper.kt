package br.edu.renata.ninjafabricsalekt.helpers

import br.edu.renata.ninjafabricsalekt.application.models.*
import br.edu.renata.ninjafabricsalekt.presentation.controllers.orders.request.CreateOrderRequest
import org.jeasy.random.EasyRandom
import java.math.BigDecimal
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

fun dummyPaymentOrder(
    id: String = UUID.randomUUID().toString(),
    status: String = "OPENED",
    customer: Customer = EasyRandom().nextObject(Customer::class.java).copy(id = UUID.randomUUID().toString()),
    order: Order = getDummyOrder()
) = PaymentOrder(
    id = id,
    status = status,
    customer = customer,
    order = order
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
        status = status.name,
        shippingModality = shippingModality.name,
        cashPaymentType = cashPaymentType.name,
        observation = observation,
        createdAt = ZonedDateTime.now(),
        updatedAt = ZonedDateTime.now()
    )

fun getDummyItem(
    fabric: Fabric = EasyRandom().nextObject(Fabric::class.java),
    quantity: Int = 3,
    color: String = Color.RED.name,
    status: String = InventoryItem.Status.STOCK.name,
    packaging: String = "ROLL",
    unitPrice: BigDecimal = BigDecimal(10.4),
    size: Int = 30
) = InventoryItem(
    fabric = fabric,
    quantity = quantity,
    color = color,
    status = status,
    packaging = packaging,
    unitPrice = unitPrice,
    size = size
)