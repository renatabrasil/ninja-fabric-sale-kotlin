package br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.employees

import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities.EmployeeEntity
import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.repositories.EmployeeRepository
import br.edu.renata.ninjafabricsalekt.application.domain.Employee
import br.edu.renata.ninjafabricsalekt.application.ports.outbound.GetEmployeeByIdPort
import org.springframework.stereotype.Component

@Component
class GetEmployeeByIdAdapter(private val employeeRepository: EmployeeRepository) : GetEmployeeByIdPort {
    override fun findById(id: String): Employee {
        return try {
            employeeRepository.findById(id).get().toDomain()
        } catch (ex: Exception) {
            println(ex.stackTrace)
            throw ex

        }
    }
}