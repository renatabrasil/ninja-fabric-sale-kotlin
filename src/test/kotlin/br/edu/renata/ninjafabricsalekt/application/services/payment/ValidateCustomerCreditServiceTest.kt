package br.edu.renata.ninjafabricsalekt.application.services.payment

import br.edu.renata.ninjafabricsalekt.application.models.PaymentOrder
import br.edu.renata.ninjafabricsalekt.application.repositories.PaymentOrderRepository
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

internal class ValidateCustomerCreditServiceTest {

    private val repository: PaymentOrderRepository = mock()

    private val service = ValidateCustomerCreditService(repository)

    @Test
    fun `Verify if validates customer credit when there is no Payment Order OPEN`() {
        // Given
        val customerId = "0bab69e0-c2aa-4187-8806-d69fadb7f3a1"
        whenever(
            repository.countByCustomer_IdAndStatus(
                eq(customerId),
                eq(PaymentOrder.Status.OPENED.name)
            )
        ).thenReturn(0)

        // When
        val response = service.execute(customerId)

        // Then
        assertTrue(response)
        verify(repository, only()).countByCustomer_IdAndStatus(any(), any())

    }

    @Test
    fun `Verify if validates customer credit when there is payment order in OPEN status`() {
        // Given
        val customerId = "0bab69e0-c2aa-4187-8806-d69fadb7f3a1"
        whenever(
            repository.countByCustomer_IdAndStatus(
                eq(customerId),
                eq(PaymentOrder.Status.OPENED.name)
            )
        ).thenReturn(2)

        // When
        val response = service.execute(customerId)

        // Then
        assertFalse(response)
        verify(repository, only()).countByCustomer_IdAndStatus(any(), any())

    }
}