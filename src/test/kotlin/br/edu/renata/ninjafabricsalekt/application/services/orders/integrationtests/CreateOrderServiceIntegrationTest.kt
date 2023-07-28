//package br.edu.renata.ninjafabricsalekt.application.services.orders.integrationtests
//
//import br.edu.renata.ninjafabricsalekt.application.repositories.OrderRepository
//import br.edu.renata.ninjafabricsalekt.application.services.orders.CreateOrderService
//import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.CheckProductsInStockUseCase
//import br.edu.renata.ninjafabricsalekt.application.usecases.payment.ValidateCustomerCreditUseCase
//import br.edu.renata.ninjafabricsalekt.helpers.getDummyOrder
//import org.junit.jupiter.api.Test
//import org.mockito.kotlin.eq
//import org.mockito.kotlin.mock
//import org.mockito.kotlin.whenever
//
////@ExtendWith(SpringExtension::class)
////@SpringBootTest
////@AutoConfigureMockMvc
//internal class CreateOrderServiceIntegrationTest {
//
//    private val orderRepository: OrderRepository = mock()
//    private val validateCustomerCreditUseCase: ValidateCustomerCreditUseCase = mock()
//    private val checkProductsInStockUseCase: CheckProductsInStockUseCase = mock()
//
//    private val createOrderService = CreateOrderService(
//        orderRepository = orderRepository,
//        validateCustomerCreditUseCase = validateCustomerCreditUseCase,
//        checkProductsInStockUseCase = checkProductsInStockUseCase
//    )
//
//    @Test
//    fun `Verify creation of order with customer valid and products in stock sucessfully`() {
//        // Given
//        val orderRequest = getDummyOrder()
//        whenever(validateCustomerCreditUseCase.execute(eq(orderRequest.customer.id))).thenReturn(true)
//
//        val response = createOrderService.execute(orderRequest)
//
//    }
//}