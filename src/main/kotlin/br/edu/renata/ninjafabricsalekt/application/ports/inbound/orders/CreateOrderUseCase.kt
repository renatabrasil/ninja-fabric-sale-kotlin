package br.edu.renata.ninjafabricsalekt.application.ports.inbound.orders

import br.edu.renata.ninjafabricsalekt.application.domain.orders.Order

interface CreateOrderUseCase {
    fun execute(creationOrderRequest: Order)
}