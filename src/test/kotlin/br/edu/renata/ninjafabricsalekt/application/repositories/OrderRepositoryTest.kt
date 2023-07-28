package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.helpers.getDummyOrder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@Tag(value = "integration")
internal class OrderRepositoryTest {
    @Autowired
    private lateinit var orderRepository: OrderRepository

    @Test
    fun `Verify if gets order by seller successfully`() {
        // Given
        val seller = "Benedito"
        val testOrders = listOf(
            getDummyOrder(id = "1", seller = seller),
            getDummyOrder(id = "2", seller = "Jim"),
            getDummyOrder(id = "3", seller = "Marta"),
            getDummyOrder(id = "4", seller = seller)
        )
        val expected = testOrders.filter { it.seller == seller }.map { it.id }
        orderRepository.saveAll(testOrders)

        // When
        val response = orderRepository.findBySeller(seller = seller)

        // Then
        assertEquals(expected, response.map { it.id })

    }
}