package br.edu.renata.ninjafabricsalekt.application.ports.inbound.inventory

import br.edu.renata.ninjafabricsalekt.application.domain.inventory.Product
import br.edu.renata.ninjafabricsalekt.application.domain.management.Fabric

interface FindProductsInInventoryUseCase {

    fun execute(fabric: Fabric) : List<Product>
}