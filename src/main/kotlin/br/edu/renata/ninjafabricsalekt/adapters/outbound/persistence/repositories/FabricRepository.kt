package br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.repositories

import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities.FabricEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FabricRepository: CrudRepository<FabricEntity, String> {
}