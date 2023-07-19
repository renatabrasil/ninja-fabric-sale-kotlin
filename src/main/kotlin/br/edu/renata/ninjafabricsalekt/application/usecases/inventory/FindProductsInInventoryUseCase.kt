package br.edu.renata.ninjafabricsalekt.application.usecases.inventory

import br.edu.renata.ninjafabricsalekt.application.models.Product
import br.edu.renata.ninjafabricsalekt.application.models.Fabric

interface FindProductsInInventoryUseCase {

    fun execute(fabric: Fabric) : List<Product>
}