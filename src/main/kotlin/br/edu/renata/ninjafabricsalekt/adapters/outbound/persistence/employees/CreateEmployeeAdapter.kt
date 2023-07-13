package br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.employees

import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities.EmployeeEntity
import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.repositories.EmployeeRepository
import br.edu.renata.ninjafabricsalekt.application.domain.Employee
import br.edu.renata.ninjafabricsalekt.application.ports.outbound.CreateEmployeePort
import org.springframework.stereotype.Component

@Component
class CreateEmployeeAdapter(private val employeesRepository: EmployeeRepository) : CreateEmployeePort {
    override fun save(employee: Employee) {
        employeesRepository.save(employee.toEntity())
    }
}