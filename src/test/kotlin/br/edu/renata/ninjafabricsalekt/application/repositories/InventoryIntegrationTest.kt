package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.application.models.Color
import br.edu.renata.ninjafabricsalekt.application.models.Fabric
import br.edu.renata.ninjafabricsalekt.application.models.InventoryItem
import br.edu.renata.ninjafabricsalekt.helpers.dummyObject
import br.edu.renata.ninjafabricsalekt.helpers.getDummyItem
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.*

@DataJpaTest
class InventoryIntegrationTest {

    @Autowired
    private lateinit var inventoryRepository: InventoryRepository

    @Test
    fun `Should return item given a fabric and color successfully`() {
        // Given
        val fabric =
            dummyObject<Fabric>().copy(id = UUID.randomUUID().toString(), name = "LINHO", description = "100% Linho")
        val redColor = Color.RED.name
        val anotherFabric = dummyObject<Fabric>().copy(
            id = UUID.randomUUID().toString(),
            name = "ALGODAO",
            description = "100% Algodao"
        )
        val expectedResponse = getDummyItem(color = redColor, fabric = fabric, packaging = InventoryItem.Packaging.ROLL.name)
        val items = listOf(
            getDummyItem(color = Color.BLUE.name, fabric = fabric, packaging = InventoryItem.Packaging.ROLL.name),
            expectedResponse,
            getDummyItem(color = redColor, fabric = anotherFabric, packaging = InventoryItem.Packaging.ROLL.name),
            getDummyItem(color = redColor, fabric = fabric, packaging = InventoryItem.Packaging.DETACHED.name)
        )
        inventoryRepository.saveAll(
            items
        )

        // When
        val response =
            inventoryRepository.findByProductItemParams(fabricName = fabric.name, color = redColor, packaging = "ROLL")

        // Then
        assertEquals(expectedResponse.id, response.get(0).id)
    }
}