package br.edu.renata.ninjafabricsalekt.presentation.controllers.employees

import br.edu.renata.ninjafabricsalekt.application.usecases.employees.CreateEmployeeUseCase
import br.edu.renata.ninjafabricsalekt.application.usecases.employees.GetEmployeeByIdUseCase
import br.edu.renata.ninjafabricsalekt.application.usecases.employees.GetEmployeesUseCase
import br.edu.renata.ninjafabricsalekt.presentation.apis.EmployeeApi
import br.edu.renata.ninjafabricsalekt.presentation.controllers.employees.requests.CreateEmployeeRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController(
    private val createEmployeeUseCase: CreateEmployeeUseCase,
    private val getEmployeeByIdUseCase: GetEmployeeByIdUseCase,
    private val getEmployeesUseCase: GetEmployeesUseCase
) : EmployeeApi {

    override fun createEmployee(@RequestBody employeeRequest: CreateEmployeeRequest) {
        createEmployeeUseCase.execute(employeeRequest)
    }

    override fun getEmployeeById(@PathVariable("employeeId") id: String) =
        ResponseEntity(getEmployeeByIdUseCase.execute(id), HttpStatus.OK)

    override fun getEmployees() = ResponseEntity(getEmployeesUseCase.execute(), HttpStatus.OK)
}