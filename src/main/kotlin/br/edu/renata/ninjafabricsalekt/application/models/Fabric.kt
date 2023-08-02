package br.edu.renata.ninjafabricsalekt.application.models

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Fabric(
    @Id
    val id: String?,
    val name: String,
    val description: String?,
    val code: String?,
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    val createdAt: ZonedDateTime?,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: ZonedDateTime?
)