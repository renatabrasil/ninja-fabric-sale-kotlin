package br.edu.renata.ninjafabricsalekt.adapters.inbound.web.employees

import br.edu.renata.ninjafabricsalekt.adapters.inbound.web.employees.requests.CreateEmployeeRequest
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.employees.CreateEmployeeUseCase
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.employees.GetEmployeeByIdUseCase
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.employees.GetEmployeesUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
class EmployeeController(
    private val createEmployeeUseCase: CreateEmployeeUseCase,
    private val getEmployeeByIdUseCase: GetEmployeeByIdUseCase,
    private val getEmployeesUseCase: GetEmployeesUseCase
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createEmployee(@RequestBody employeeRequest: CreateEmployeeRequest) {
        createEmployeeUseCase.execute(employeeRequest)
    }

    @GetMapping("/{employeeId}")
    fun getEmployeeById(@PathVariable("employeeId") id: String) =
        ResponseEntity(getEmployeeByIdUseCase.execute(id), HttpStatus.OK)

    @GetMapping
    fun getEmployees() = getEmployeesUseCase.execute()
}