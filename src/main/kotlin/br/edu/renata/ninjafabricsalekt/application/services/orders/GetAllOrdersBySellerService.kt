package br.edu.renata.ninjafabricsalekt.application.services.orders

import br.edu.renata.ninjafabricsalekt.application.models.Order
import br.edu.renata.ninjafabricsalekt.application.repositories.OrderRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.orders.GetAllOrdersBySellerUseCase
import org.springframework.stereotype.Service

@Service
class GetAllOrdersBySellerService(private val orderRepository: OrderRepository) : GetAllOrdersBySellerUseCase {
    override fun execute(seller: String): List<Order> {
        return orderRepository.findBySeller(seller)
    }
}