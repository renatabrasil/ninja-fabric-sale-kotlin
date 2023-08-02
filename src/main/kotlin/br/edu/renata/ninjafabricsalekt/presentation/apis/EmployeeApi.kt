package br.edu.renata.ninjafabricsalekt.presentation.apis

import br.edu.renata.ninjafabricsalekt.presentation.controllers.employees.requests.CreateEmployeeRequest
import br.edu.renata.ninjafabricsalekt.application.models.Employee
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
interface EmployeeApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createEmployee(@RequestBody createEmployeeRequest: CreateEmployeeRequest)

    @GetMapping("/{employeeId}")
    fun getEmployeeById(@PathVariable("employeeId") id: String): ResponseEntity<Employee>

    @GetMapping
    fun getEmployees() : ResponseEntity<List<Employee>>
}