package br.edu.renata.ninjafabricsalekt.application.models

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
