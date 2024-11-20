package br.edu.renata.ninjafabricsalekt.application.services.employees

import br.edu.renata.ninjafabricsalekt.application.repositories.EmployeeRepository
import br.edu.renata.ninjafabricsalekt.application.usecases.employees.CreateEmployeeUseCase
import br.edu.renata.ninjafabricsalekt.presentation.controllers.employees.requests.CreateEmployeeRequest
import org.springframework.stereotype.Service

@Service
class CreateEmployeeService(private val employeeRepository: EmployeeRepository) :
    CreateEmployeeUseCase {
    override fun execute(createEmployeeRequest: CreateEmployeeRequest) {
        employeeRepository.save(createEmployeeRequest.toDomain())
    }
}