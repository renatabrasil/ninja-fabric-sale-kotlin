package br.edu.renata.ninjafabricsalekt.application.services.orders

import br.edu.renata.ninjafabricsalekt.application.repositories.OrderRepository
import br.edu.renata.ninjafabricsalekt.helpers.getDummyOrder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*


internal class GetAllOrdersBySellerServiceTest {

    private val orderRepository: OrderRepository = mock()

    private val getAllOrdersBySellerService = GetAllOrdersBySellerService(orderRepository)

    @Test
    fun `Verify if get all orders by a given Seller name successfully`() {
        // Given
        val seller = "Benedito"
        val expectedResponse = listOf(
            getDummyOrder(id = "1", seller = seller),
            getDummyOrder(id = "4", seller = seller)
        )
        whenever(orderRepository.findBySeller(eq(seller))).thenReturn(expectedResponse)

        // When
        val response = getAllOrdersBySellerService.execute(seller = seller)

        // Then
        assertEquals(expectedResponse, response)
        verify(orderRepository).findBySeller(any())
    }
}