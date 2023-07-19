package br.edu.renata.ninjafabricsalekt.application.services.orders

import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.FindProductsInInventoryUseCase
import br.edu.renata.ninjafabricsalekt.application.usecases.payment.FindOpenedPaymentOrderByCustomerUseCase
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

class CreateOrderServiceTest {
    private val findOpenedPaymentOrderByCustomerUseCase = mock(FindOpenedPaymentOrderByCustomerUseCase::class.java)
    private val findProductsInInventoryUseCase = mock(FindProductsInInventoryUseCase::class.java)

    private val createOrderService =
        CreateOrderService(findOpenedPaymentOrderByCustomerUseCase, findProductsInInventoryUseCase)

    @Test
    fun `Validate create order successfully`() {


    }
}