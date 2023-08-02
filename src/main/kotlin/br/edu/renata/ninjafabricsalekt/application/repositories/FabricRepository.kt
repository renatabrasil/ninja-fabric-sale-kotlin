package br.edu.renata.ninjafabricsalekt.application.repositories

import br.edu.renata.ninjafabricsalekt.application.models.Fabric
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FabricRepository : CrudRepository<Fabric, String> {
}