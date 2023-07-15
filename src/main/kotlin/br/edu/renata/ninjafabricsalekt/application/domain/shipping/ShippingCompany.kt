package br.edu.renata.ninjafabricsalekt.application.domain.shipping

import br.edu.renata.ninjafabricsalekt.application.domain.orders.Customer
import br.edu.renata.ninjafabricsalekt.application.domain.orders.Order

data class ShippingCompany(
    val id: String?,
    val completeName: String,
    val cnpj: String,
    val address: Customer.Address,
    val supportedShippingModalities: List<Order.ShippingModality>,
    val deliveryScope: DeliveryScope,
    val active: Boolean = true,
) {
    enum class DeliveryScope {
        UP_TO_5_KM,
        UP_TO_50_KM,
        UP_TO_100_KM,
        NO_RESTRICTION_WITHIN_COUNTRY
    }

}
