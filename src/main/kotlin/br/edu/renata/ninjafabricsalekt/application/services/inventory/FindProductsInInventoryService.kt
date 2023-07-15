package br.edu.renata.ninjafabricsalekt.application.services.inventory

import br.edu.renata.ninjafabricsalekt.application.domain.inventory.Product
import br.edu.renata.ninjafabricsalekt.application.domain.management.Fabric
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.inventory.FindProductsInInventoryUseCase

class FindProductsInInventoryService: FindProductsInInventoryUseCase {
    override fun execute(fabric: Fabric): List<Product> {
        TODO("Not yet implemented")
    }
}