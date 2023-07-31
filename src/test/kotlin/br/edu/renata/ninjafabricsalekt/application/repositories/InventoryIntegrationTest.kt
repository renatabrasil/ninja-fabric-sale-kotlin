package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.application.models.Color
import br.edu.renata.ninjafabricsalekt.application.models.Fabric
import br.edu.renata.ninjafabricsalekt.application.models.InventoryItem
import br.edu.renata.ninjafabricsalekt.helpers.getDummyItem
import org.jeasy.random.EasyRandom
import org.junit.Assert.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class InventoryIntegrationTest {

    @Autowired
    private lateinit var inventoryRepository: InventoryRepository

    @Test
    fun `Should return item given a fabric and color successfully`() {
        // Given
        val fabric = EasyRandom().nextObject(Fabric::class.java).copy(name = "LINHO", description = "100% Linho")
        val anotherFabric =
            EasyRandom().nextObject(Fabric::class.java).copy(name = "ALGODAO", description = "100% Algodao")
        val items = listOf(
            getDummyItem(color = Color.BLUE.name, fabric = fabric),
            getDummyItem(color = Color.GREEN.name, fabric = fabric),
            getDummyItem(color = Color.RED.name, fabric = anotherFabric),
            getDummyItem(color = Color.RED.name, fabric = fabric)
        )
        inventoryRepository.saveAll(
            items
        )
        val expectedResponse = items.filter { it.fabric.name == fabric.name && it.color == Color.RED.name }

        // When
        val response = inventoryRepository.findByFabric_NameAndColor(fabric.name, Color.RED.name)

        // Then
        assertEquals(expectedResponse, response)
    }
}