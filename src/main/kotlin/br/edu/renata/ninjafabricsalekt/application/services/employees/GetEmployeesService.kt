package br.edu.renata.ninjafabricsalekt.application.services.employees

import br.edu.renata.ninjafabricsalekt.application.repositories.EmployeeRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.employees.GetEmployeesUseCase
import org.springframework.stereotype.Service

@Service
class GetEmployeesService(private val employeeRepository: EmployeeRepository) : GetEmployeesUseCase {
    override fun execute() = employeeRepository.findAll().toList()
}