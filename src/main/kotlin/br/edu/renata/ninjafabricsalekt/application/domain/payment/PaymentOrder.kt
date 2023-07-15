package br.edu.renata.ninjafabricsalekt.application.domain.payment

import br.edu.renata.ninjafabricsalekt.application.domain.orders.Customer
import br.edu.renata.ninjafabricsalekt.application.domain.orders.Order

data class PaymentOrder(
    val id: String?,
    val status: Status,
    val customer: Customer,
    val order: Order
) {
    enum class Status{
        OPENED,
        CANCELLED,
        FINISHED
    }

}
