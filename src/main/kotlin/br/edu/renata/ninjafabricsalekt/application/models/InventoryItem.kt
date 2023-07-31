package br.edu.renata.ninjafabricsalekt.application.models

import br.edu.renata.ninjafabricsalekt.application.utils.ColorConverter
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.*

@Entity(name = "inventory_item")
data class InventoryItem(
    @Id
    val id: String? = UUID.randomUUID().toString(),

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "fabric_id")
    val fabric: Fabric,

//    @Convert(converter = ColorConverter::class)
    val color: String,

    val packaging: String,

    val size: Int,

    val quantity: Int,

    @Column(name = "unit_price")
    val unitPrice: BigDecimal,

    val status: String,

    @Column(name = "updated_by", nullable = true, updatable = false)
    val updatedBy: String? = null,

    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: ZonedDateTime? = null

) {
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
