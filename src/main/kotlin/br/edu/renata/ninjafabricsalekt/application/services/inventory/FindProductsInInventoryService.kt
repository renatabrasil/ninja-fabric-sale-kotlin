package br.edu.renata.ninjafabricsalekt.application.services.inventory

import br.edu.renata.ninjafabricsalekt.application.models.Product
import br.edu.renata.ninjafabricsalekt.application.models.Fabric
import br.edu.renata.ninjafabricsalekt.application.usecases.inventory.FindProductsInInventoryUseCase
import org.springframework.stereotype.Service

@Service
class FindProductsInInventoryService: FindProductsInInventoryUseCase {
    override fun execute(fabric: Fabric): List<Product> {
        TODO("Not yet implemented")
    }
}