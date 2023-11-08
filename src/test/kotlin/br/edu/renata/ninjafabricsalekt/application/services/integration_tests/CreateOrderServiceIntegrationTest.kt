import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

//package br.edu.renata.ninjafabricsalekt.application.services.integration_tests
//
//import br.edu.renata.ninjafabricsalekt.application.repositories.OrderRepository
//import br.edu.renata.ninjafabricsalekt.application.services.orders.CreateOrderService
//import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.CheckProductsInStockUseCase
//import br.edu.renata.ninjafabricsalekt.application.usecases.payment.ValidateCustomerCreditUseCase
//import br.edu.renata.ninjafabricsalekt.helpers.getDummyOrder
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.extension.ExtendWith
//import org.mockito.kotlin.eq
//import org.mockito.kotlin.mock
//import org.mockito.kotlin.whenever
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.junit.jupiter.SpringExtension
//
//@ExtendWith(SpringExtension::class)
//@SpringBootTest
////@WebMvcTest
//@AutoConfigureMockMvc
//internal class CreateOrderServiceIntegrationTest {
//
//    private val orderRepository: OrderRepository = mock()
//    private val validateCustomerCreditUseCase: ValidateCustomerCreditUseCase = mock()
//    private val checkProductsInStockUseCase: CheckProductsInStockUseCase = mock()
//
//    @Autowired
//    private lateinit var createOrderService: CreateOrderService
////    private val createOrderService = CreateOrderService(
////        orderRepository = orderRepository,
////        validateCustomerCreditUseCase = validateCustomerCreditUseCase,
////        checkProductsInStockUseCase = checkProductsInStockUseCase
////    )
//
//    @Test
//    fun `Verify creation of order with customer valid and products in stock sucessfully`() {
//        // Given
//        val orderRequest = getDummyOrder()
////        whenever(validateCustomerCreditUseCase.execute(eq(orderRequest.customer.id))).thenReturn(true)
//
//        // When
//        val response = createOrderService.execute(orderRequest)
//
//        // Then
//
//
//    }
//}