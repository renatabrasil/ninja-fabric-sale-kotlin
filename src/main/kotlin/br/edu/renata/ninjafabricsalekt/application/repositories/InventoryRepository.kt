package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.application.models.InventoryItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository : JpaRepository<InventoryItem, String> {

    @Query(
        "SELECT item.* FROM inventory_item item " +
                " INNER JOIN fabric fabric_ ON item.fabric_id = fabric_.id " +
                " WHERE color LIKE :color AND fabric_.name LIKE :fabricName AND packaging LIKE :packaging ",
        nativeQuery = true
    )
    fun findByProductItemParams(
        @Param("color") color: String,
        @Param("fabricName") fabricName: String,
        @Param("packaging") packaging: String
    ): List<InventoryItem>

    fun findByProductId(productId: String): List<InventoryItem>


}