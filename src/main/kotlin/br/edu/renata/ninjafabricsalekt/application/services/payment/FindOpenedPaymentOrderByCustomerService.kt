package br.edu.renata.ninjafabricsalekt.application.services.payment

import br.edu.renata.ninjafabricsalekt.application.models.PaymentOrder
import br.edu.renata.ninjafabricsalekt.application.usecases.payment.FindOpenedPaymentOrderByCustomerUseCase
import org.springframework.stereotype.Service

@Service
class FindOpenedPaymentOrderByCustomerService(

): FindOpenedPaymentOrderByCustomerUseCase {
    override fun execute(customerId: String): List<PaymentOrder> {
        return emptyList()
        // 1 - Busca ordens de pagamento com status = OPENED
    }
}