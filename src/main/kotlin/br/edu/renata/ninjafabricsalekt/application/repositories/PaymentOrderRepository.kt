package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.application.models.PaymentOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentOrderRepository : JpaRepository<PaymentOrder, String> {
    fun countByCustomer_IdAndStatus(id: String, status: String): Int
}