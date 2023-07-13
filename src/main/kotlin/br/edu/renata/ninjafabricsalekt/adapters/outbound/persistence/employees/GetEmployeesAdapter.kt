package br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.employees

import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.repositories.EmployeeRepository
import br.edu.renata.ninjafabricsalekt.application.ports.outbound.GetEmployeesPort
import org.springframework.stereotype.Component

@Component
class GetEmployeesAdapter(private val employeeRepository: EmployeeRepository) : GetEmployeesPort {
    override fun findAll() = employeeRepository.findAll().map { it.toDomain() }
}