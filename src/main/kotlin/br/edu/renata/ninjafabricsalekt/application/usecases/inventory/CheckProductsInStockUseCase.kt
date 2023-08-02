package br.edu.renata.ninjafabricsalekt.application.usecases.inventory

import br.edu.renata.ninjafabricsalekt.application.models.Order

interface CheckProductsInStockUseCase {
    fun execute(productItems: List<Order.ProductItem>): List<Order.ProductItem>
}