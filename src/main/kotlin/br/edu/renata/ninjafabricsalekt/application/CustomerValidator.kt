package br.edu.renata.ninjafabricsalekt.application

import br.edu.renata.ninjafabricsalekt.application.services.employees.GetEmployeeByIdService
import br.edu.renata.ninjafabricsalekt.application.services.orders.CreateOrderService
import br.edu.renata.ninjafabricsalekt.application.services.payment.FindOpenedPaymentOrderByCustomerService
import br.edu.renata.ninjafabricsalekt.application.services.payment.ValidateCustomerCreditService

class CustomerValidator(
    private val getEmployeeByIdService: GetEmployeeByIdService,
    private val validateCustomerCreditService: ValidateCustomerCreditService
): InstanceValidator {
    override fun validate(): Boolean {
        print("Validador de cliente")
        return true
    }
}