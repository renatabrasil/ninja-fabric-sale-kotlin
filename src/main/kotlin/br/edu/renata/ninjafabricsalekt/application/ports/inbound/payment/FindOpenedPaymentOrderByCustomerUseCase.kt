package br.edu.renata.ninjafabricsalekt.application.ports.inbound.payment

import br.edu.renata.ninjafabricsalekt.application.domain.payment.PaymentOrder

interface FindOpenedPaymentOrderByCustomerUseCase {
    fun execute(customerId: String): List<PaymentOrder>
}