package br.edu.renata.ninjafabricsalekt.application.usecases.orders

import br.edu.renata.ninjafabricsalekt.application.models.Order

interface UpdateOrderStatusUseCase {
    fun execute(order: Order, status: Order.Status)
}