package br.edu.renata.ninjafabricsalekt.application.services.payment

import br.edu.renata.ninjafabricsalekt.application.usecases.payment.ValidateCustomerCreditUseCase
import org.springframework.stereotype.Service

@Service
class ValidateCustomerCreditService : ValidateCustomerCreditUseCase {
    override fun execute(customerId: String): Boolean {
        TODO("Not yet implemented")
        // 1 - Validate customer credit (verifica se o cliente tem pagamento em aberto) - Status -> CONFIRMED
    }
}