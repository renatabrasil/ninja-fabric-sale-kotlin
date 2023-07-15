package br.edu.renata.ninjafabricsalekt.application.services.orders

import br.edu.renata.ninjafabricsalekt.application.domain.inventory.Product
import br.edu.renata.ninjafabricsalekt.application.domain.orders.Order
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.inventory.FindProductsInInventoryUseCase
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.orders.CreateOrderUseCase
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.payment.FindOpenedPaymentOrderByCustomerUseCase

class CreateOrderService(
    private val findOpenedPaymentOrderByCustomerUseCase: FindOpenedPaymentOrderByCustomerUseCase,
    private val findProductsInInventoryUseCase: FindProductsInInventoryUseCase
) :
    CreateOrderUseCase {
    override fun execute(creationOrderRequest: Order) {
        TODO("Not yet implemented")
        // Englobar tudo num contexto transacional
        // 1 - Validate payment (verifica se tem pagamento em aberto) - Status -> CONFIRMED
        if (findOpenedPaymentOrderByCustomerUseCase.execute(creationOrderRequest.customer.id).isNotEmpty()) {
            // Throws exception
        }
        // 2 - Validate product stocks (verifica quais produtos estão no estoque) - remove out of stock products - Status -> IN_PROGRESS
        val availableProductItems = mutableListOf<Order.ProductItem>()
        for (item in creationOrderRequest.productItems) {
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
        // 3 - When received Status READY from Shipping module Status -> IN_DELIVERING
        // 4 - When period setted by shipping module expires - Status -> FINISHED

    }
}