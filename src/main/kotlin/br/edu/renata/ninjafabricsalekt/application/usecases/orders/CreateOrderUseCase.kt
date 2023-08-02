package br.edu.renata.ninjafabricsalekt.application.usecases.orders

import br.edu.renata.ninjafabricsalekt.application.models.Order

interface CreateOrderUseCase {
    fun execute(creationOrderRequest: Order)
}