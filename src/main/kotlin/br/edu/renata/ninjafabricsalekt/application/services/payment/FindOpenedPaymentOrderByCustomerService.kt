package br.edu.renata.ninjafabricsalekt.application.services.payment

import br.edu.renata.ninjafabricsalekt.application.domain.payment.PaymentOrder
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.payment.FindOpenedPaymentOrderByCustomerUseCase

class FindOpenedPaymentOrderByCustomerService: FindOpenedPaymentOrderByCustomerUseCase {
    override fun execute(customerId: String): List<PaymentOrder> {
        TODO("Not yet implemented")
        // 1 - Busca ordens de pagamento com status = OPENED
    }
}