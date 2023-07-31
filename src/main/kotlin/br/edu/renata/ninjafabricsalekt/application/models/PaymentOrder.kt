package br.edu.renata.ninjafabricsalekt.application.models

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.*

@Entity(name = "payment_order")
data class PaymentOrder(
    @Id
    val id: String? = UUID.randomUUID().toString(),

    val status: String,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    val customer: Customer,

//    @OneToOne @MapsId
//    @JoinColumn(name = "order_id")
    @Transient
    val order: Order,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    val createdAt: ZonedDateTime? = null,

    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: ZonedDateTime? = null

) {
    enum class Status {
        OPENED,
        CANCELLED,
        FINISHED
    }

}
