package br.edu.renata.ninjafabricsalekt.application.services.employees

import br.edu.renata.ninjafabricsalekt.application.models.Employee
import br.edu.renata.ninjafabricsalekt.application.repositories.EmployeeRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.employees.GetEmployeeByIdUseCase
import org.springframework.stereotype.Service

@Service
class GetEmployeeByIdService(private val employeeRepository: EmployeeRepository) : GetEmployeeByIdUseCase {
    override fun execute(id: String): Employee {
        return employeeRepository.findById(id).get()
    }
}