package br.edu.renata.ninjafabricsalekt.application.services.payment

import br.edu.renata.ninjafabricsalekt.application.models.PaymentOrder
import br.edu.renata.ninjafabricsalekt.application.repositories.PaymentOrderRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.payment.ValidateCustomerCreditUseCase
import org.springframework.stereotype.Service

@Service
class ValidateCustomerCreditService(
    private val paymentOrderRepository: PaymentOrderRepository
) : ValidateCustomerCreditUseCase {

    override fun execute(customerId: String) =
        paymentOrderRepository.countByCustomer_IdAndStatus(customerId, PaymentOrder.Status.OPENED.name) == 0

}