package br.edu.renata.ninjafabricsalekt.application.models

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
data class Product(
    @Id
    val id: String? = UUID.randomUUID().toString(),

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "fabric_id")
    val fabric: Fabric,
    //    @Convert(converter = ColorConverter::class)
    val color: String,
    val packaging: String,
    val size: String,
    @Column(name = "unit_price")
    val unitPrice: BigDecimal
) {


}
