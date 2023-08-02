package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.application.models.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, String>
{
    fun findBySeller(seller: String): List<Order>
}