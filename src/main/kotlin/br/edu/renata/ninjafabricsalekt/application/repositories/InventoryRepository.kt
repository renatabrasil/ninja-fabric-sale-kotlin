package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.application.models.InventoryItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository : JpaRepository<InventoryItem, String> {
    fun findByFabric_NameAndColor(name: String, color: String): List<InventoryItem>
}