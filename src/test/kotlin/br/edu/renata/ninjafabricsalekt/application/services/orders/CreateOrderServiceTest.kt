package br.edu.renata.ninjafabricsalekt.application.services.orders

import br.edu.renata.ninjafabricsalekt.application.models.Order
import br.edu.renata.ninjafabricsalekt.application.repositories.OrderRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.exceptions.BusinessException
import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.CheckProductsInStockUseCase
import br.edu.renata.ninjafabricsalekt.application.usecases.payment.ValidateCustomerCreditUseCase
import br.edu.renata.ninjafabricsalekt.helpers.getCreateOrderRequest
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.*

class CreateOrderServiceTest {
    private val validateCustomerCreditUseCase: ValidateCustomerCreditUseCase = mock()
    private val checkProductsInStockUseCase: CheckProductsInStockUseCase = mock()
    private val orderRepository: OrderRepository = mock()

    private val createOrderService =
        CreateOrderService(validateCustomerCreditUseCase, checkProductsInStockUseCase, orderRepository)

    @Test
    fun `Verify creation of order with customer valid and products in stock sucessfully`() {
        // Given
        val createOrderRequest = getCreateOrderRequest()
        val productItemsInStock = emptyList<Order.ProductItem>()

        whenever(validateCustomerCreditUseCase.execute(createOrderRequest.customer.id)).thenReturn(
            true
        )
        whenever(checkProductsInStockUseCase.execute(createOrderRequest.productItems)).thenReturn(productItemsInStock)
        whenever(orderRepository.save(createOrderRequest.toDomain())).thenReturn(createOrderRequest.toDomain())

        // When
        createOrderService.execute(createOrderRequest.toDomain())

        // Then
        verify(validateCustomerCreditUseCase).execute(any())
        verify(checkProductsInStockUseCase).execute(any())
        verify(orderRepository).save(any())

    }

    @Test
    fun `Should not create an order when customer doesn't have credit`() {
        // Given
        val createOrderRequest = getCreateOrderRequest()
        val productItemsInStock = listOf(EasyRandom().nextObject(Order.ProductItem::class.java))

        whenever(validateCustomerCreditUseCase.execute(eq(createOrderRequest.customer.id))).thenReturn(
            false
        )
        whenever(checkProductsInStockUseCase.execute(createOrderRequest.productItems)).thenReturn(productItemsInStock)
        whenever(orderRepository.save(createOrderRequest.toDomain())).thenReturn(createOrderRequest.toDomain())

        // When
        createOrderService.execute(createOrderRequest.toDomain())

        // Then
        verify(validateCustomerCreditUseCase).execute(any())
        verify(checkProductsInStockUseCase, never()).execute(any())
        verify(orderRepository, never()).save(any())
    }

//    @Test
//    fun `Should throws exception when there is no product belongs to this order in stock`() {
//        // Given
//        val createOrderRequest = getCreateOrderRequest()
//
//        whenever(validateCustomerCreditUseCase.execute(eq(createOrderRequest.customer.id))).thenReturn(
//            true
//        )
//        whenever(checkProductsInStockUseCase.execute(createOrderRequest.productItems)).thenThrow(BusinessException::class.java)
//        whenever(orderRepository.save(createOrderRequest.toDomain())).thenReturn(createOrderRequest.toDomain())
//
//        // When
//        assertThrows<BusinessException> { createOrderService.execute(createOrderRequest.toDomain()) }
//
//        // Then
//        verify(validateCustomerCreditUseCase).execute(any())
//        verify(checkProductsInStockUseCase).execute(any())
//        verify(orderRepository, never()).save(any())
//    }
}