package br.edu.renata.ninjafabricsalekt.application.services.orders

import br.edu.renata.ninjafabricsalekt.application.models.Order
import br.edu.renata.ninjafabricsalekt.application.repositories.OrderRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.orders.UpdateOrderStatusUseCase
import org.springframework.stereotype.Service

@Service
class UpdateOrderStatusService(private val orderRepository: OrderRepository) : UpdateOrderStatusUseCase {
    override fun execute(order: Order, status: Order.Status) {
        with(order) {
            this.updateStatus(status)
            orderRepository.save(this)
        }
    }
}