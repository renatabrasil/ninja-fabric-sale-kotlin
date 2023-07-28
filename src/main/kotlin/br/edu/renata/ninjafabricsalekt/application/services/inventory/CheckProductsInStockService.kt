package br.edu.renata.ninjafabricsalekt.application.services.inventory

import br.edu.renata.ninjafabricsalekt.application.models.Order
import br.edu.renata.ninjafabricsalekt.application.models.Product
import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.CheckProductsInStockUseCase
import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.FindProductsInInventoryUseCase
import org.springframework.stereotype.Service

@Service
class CheckProductsInStockService(private val findProductsInInventoryUseCase: FindProductsInInventoryUseCase) :
    CheckProductsInStockUseCase {
    override fun execute(productItems: List<Order.ProductItem>): List<Order.ProductItem> {
        TODO("Not yet implemented")
        // 2 - Validate product stocks (verifica quais produtos estão no estoque) - remove out of stock products - Status -> IN_PROGRESS
        val availableProductItems = mutableListOf<Order.ProductItem>()
        for (item in productItems) {
            val product: Product = findProductsInInventoryUseCase.execute(item.fabric).get(0)
            if (product.quantity > 0) {
                if (item.quantity <= product.quantity) {
                    availableProductItems.add(item)
                } else {
                    availableProductItems.add(item.copy(quantity = product.quantity))
                }
            }
            // Remove items from inventory (if the rest of steps fails, return items to inventory
        }
        return availableProductItems
    }
}