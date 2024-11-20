package br.edu.renata.ninjafabricsalekt.application.models

import br.edu.renata.ninjafabricsalekt.application.usecases.exceptions.BusinessException
import br.edu.renata.ninjafabricsalekt.helpers.dummyObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class InventoryItemTests {

    @Test
    fun `Verify if a product isInStock`() {
        // Given
        val inventoryItem = dummyObject<InventoryItem>().copy(quantity = 2)
        val productItem = dummyObject<Order.ProductItem>().copy(quantity = 1)

        // When
        val response = inventoryItem.isInStock(productItem)

        // Then
        assertTrue(response)
    }

    @Test
    fun `Verify if a product is NOT InStock`() {
        // Given
        val inventoryItem = dummyObject<InventoryItem>().copy(quantity = 0)
        val productItem = dummyObject<Order.ProductItem>().copy(quantity = 4)

        // When
        val response = inventoryItem.isInStock(productItem)

        // Then
        assertFalse(response)
    }

    @Test
    fun `Verify if a product is NOT InStock even though there some quantity`() {
        // Given
        val inventoryItem = dummyObject<InventoryItem>().copy(quantity = 2)
        val productItem = dummyObject<Order.ProductItem>().copy(quantity = 4)

        // When
        val response = inventoryItem.isInStock(productItem)

        // Then
        assertFalse(response)
    }

    @Test
    fun `Verify whether hasStock when quantity is zero`() {
        // Given
        val dummyInventoryItem = dummyObject<InventoryItem>().copy(quantity = 0)

        // When
        val response = dummyInventoryItem.hasStock()

        // Then
        assertFalse(response)
    }

    @Test
    fun `Verify whether hasStock when quantity is greater than zero`() {
        // Given
        val dummyInventoryItem = dummyObject<InventoryItem>().copy(quantity = 2)

        // When
        val response = dummyInventoryItem.hasStock()

        // Then
        assertTrue(response)
    }

    @Test
    fun `Should remove the entire product from stock and changes status to OUT_OF_ORDER`() {
        // Given
        val inventoryItem = dummyObject<InventoryItem>().copy(quantity = 4)
        val productItem = dummyObject<Order.ProductItem>().copy(quantity = 4)
        val expectedResponse = inventoryItem.copy(quantity = 0, status = InventoryItem.Status.OUT_OF_STOCK.name)

        // When
        val response = inventoryItem.removeQuantityFromStock(productItem)

        // Then
        assertEquals(expectedResponse, response)
    }

    @Test
    fun `Should remove quantity of product from stock`() {
        // Given
        val inventoryItem = dummyObject<InventoryItem>().copy(quantity = 4)
        val productItem = dummyObject<Order.ProductItem>().copy(quantity = 2)
        val expectedResponse = inventoryItem.copy(quantity = 2)

        // When
        val response = inventoryItem.removeQuantityFromStock(productItem)

        // Then
        assertEquals(expectedResponse, response)
    }

    @Test
    fun `Should remove all quantity of product from stock but not all quantity of order, should change status`() {
        // Given
        val inventoryItem = dummyObject<InventoryItem>().copy(quantity = 2)
        val productItem = dummyObject<Order.ProductItem>().copy(quantity = 5)
        val expectedResponse = inventoryItem.copy(quantity = 2)

        // When
        val response = inventoryItem.removeQuantityFromStock(productItem)

        // Then
        assertEquals(expectedResponse, response)
    }


    @Test
    fun `Should throws exception when tries to remove quantity of product from stock and it's not in stock`() {
        // Given
        val inventoryItem = dummyObject<InventoryItem>().copy(quantity = 0)
        val productItem = dummyObject<Order.ProductItem>().copy(quantity = 2)

        // When and Then
        assertThrows<BusinessException> { inventoryItem.removeQuantityFromStock(productItem) }

    }
}