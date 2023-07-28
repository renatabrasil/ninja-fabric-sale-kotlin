package br.edu.renata.ninjafabricsalekt.application.usecases.orders

import br.edu.renata.ninjafabricsalekt.application.models.Order

interface GetAllOrdersBySellerUseCase {
    fun execute(seller: String): List<Order>
}