package br.edu.renata.ninjafabricsalekt.application.models

import br.edu.renata.ninjafabricsalekt.application.usecases.exceptions.BusinessException
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.*

@Entity(name = "inventory_item")
data class InventoryItem(
    @Id
    val id: String? = UUID.randomUUID().toString(),

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    val product: Product,

    val quantity: Int,

    val status: String,

    @Column(name = "updated_by", nullable = true, updatable = false)
    val updatedBy: String? = null,

    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: ZonedDateTime? = null

) {
    fun hasStock() = quantity > 0

    fun removeQuantityFromStock(item: Order.ProductItem): InventoryItem {

        if (quantity == 0) {
            throw BusinessException("Product: ${this.product.fabric} is OUT OF STOCK")
        }

        val residualQuantity = if (quantity < item.quantity) {
            quantity.mod(item.quantity)
        } else {
            quantity - item.quantity
        }

        val status = if (residualQuantity == 0) {
            Status.OUT_OF_STOCK.name
        } else {
            status
        }
        return this.copy(quantity = residualQuantity, status = status)
    }


    fun isInStock(item: Order.ProductItem) = item.quantity <= this.quantity

    enum class Packaging {
        ROLL,
        DETACHED
    }

    enum class Status {
        STOCK,
        OUT_OF_STOCK,
        INACTIVE
    }

}
