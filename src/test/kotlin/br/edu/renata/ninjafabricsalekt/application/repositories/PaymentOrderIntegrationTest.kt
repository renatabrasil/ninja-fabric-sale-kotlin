package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.application.models.Customer
import br.edu.renata.ninjafabricsalekt.helpers.dummyPaymentOrder
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@Tag("integration")
internal class PaymentOrderIntegrationTest {

    @Autowired
    private lateinit var repository: PaymentOrderRepository

    @Test
    fun `Verify counting paymentOrder by customerId and a given status`() {
        // Given
        val interestedStatus = "OPENED"
        val customer = EasyRandom().nextObject(Customer::class.java).copy(id = "2589180a-d719-4c5a-bccd-fa0342a9a46c")
        val anotherCustomer =
            EasyRandom().nextObject(Customer::class.java).copy(id = "0bab69e0-c2aa-4187-8806-d69fadb7f3a1")
        repository.saveAll(
            listOf(
                dummyPaymentOrder(customer = customer, status = interestedStatus), // 1
                dummyPaymentOrder(customer = customer, status = "FINISHED"),
                dummyPaymentOrder(customer = customer, status = "FINISHED"),
                dummyPaymentOrder(customer = customer, status = interestedStatus), // 1
                dummyPaymentOrder(customer = anotherCustomer, status = interestedStatus),
                dummyPaymentOrder(customer = customer, status = "CLOSED"),
            )
        )

        // When
        val response = repository.countByCustomer_IdAndStatus(customer.id, interestedStatus)

        // Then
        assertEquals(2, response)

    }
}