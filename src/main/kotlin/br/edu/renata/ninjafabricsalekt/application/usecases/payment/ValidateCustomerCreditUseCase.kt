package br.edu.renata.ninjafabricsalekt.application.usecases.payment

interface ValidateCustomerCreditUseCase {
    fun execute(customerId: String): Boolean
}