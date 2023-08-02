package br.edu.renata.ninjafabricsalekt.application.usecases.payment

import br.edu.renata.ninjafabricsalekt.application.models.PaymentOrder

interface FindOpenedPaymentOrderByCustomerUseCase {
    fun execute(customerId: String): List<PaymentOrder>
}