package br.edu.renata.ninjafabricsalekt.application.services.inventory

import br.edu.renata.ninjafabricsalekt.application.models.InventoryItem
import br.edu.renata.ninjafabricsalekt.application.models.Order
import br.edu.renata.ninjafabricsalekt.application.repositories.InventoryRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.exceptions.BusinessException
import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.CheckProductsInStockUseCase
import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.FindProductsInInventoryUseCase
import org.springframework.stereotype.Service

@Service
class CheckProductsInStockService(
    private val repository: InventoryRepository,
    private val findProductsInInventoryUseCase: FindProductsInInventoryUseCase
) : CheckProductsInStockUseCase {

    override fun execute(productItems: List<Order.ProductItem>): List<Order.ProductItem> {
        TODO("Not yet implemented")
        // 2 - Validate product stocks (verifica quais produtos estão no estoque) - remove out of stock products - Status -> IN_PROGRESS
        val availableProductItems = mutableListOf<Order.ProductItem>()
        for (item in productItems) {
            val productInStock = repository.findByProductId(item.product.id!!).get(0)
            if (productInStock.hasStock()) {
                if (productInStock.isInStock(item)) {
                    availableProductItems.add(item)
                } else {
                    availableProductItems.add(item.copy(quantity = productInStock.quantity))
                }
                updateProductInStock(productInStock.removeQuantityFromStock(item))
            } else {
                throw BusinessException("Product unavailable")
            }
            // Remove items from inventory (if the rest of steps fails, return items to inventory
        }
        return availableProductItems
    }

    private fun updateProductInStock(productInStock: InventoryItem) {
        repository.save(productInStock)

    }
}