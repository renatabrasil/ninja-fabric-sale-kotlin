package br.edu.renata.ninjafabricsalekt.application.services.orders

import br.edu.renata.ninjafabricsalekt.application.models.Order
import br.edu.renata.ninjafabricsalekt.application.repositories.OrderRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.CheckProductsInStockUseCase
import br.edu.renata.ninjafabricsalekt.application.usecases.orders.CreateOrderUseCase
import br.edu.renata.ninjafabricsalekt.application.usecases.payment.ValidateCustomerCreditUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateOrderService(
    private val validateCustomerCreditUseCase: ValidateCustomerCreditUseCase,
    private val checkProductsInStockUseCase: CheckProductsInStockUseCase,
    private val orderRepository: OrderRepository
) :
    CreateOrderUseCase {

    @Transactional
    override fun execute(creationOrderRequest: Order) {
        // Englobar tudo num contexto transacional
        creationOrderRequest.takeIf {
            validateCustomerCreditUseCase.execute(customerId = creationOrderRequest.customer.id)
        }?.run {
            productItems = checkProductsInStockUseCase.execute(productItems)
            orderRepository.save(this)
        }

        // 3 - When received Status READY from Shipping module Status -> IN_DELIVERING
        // 4 - When period set by shipping module expires - Status -> FINISHED


    }

}