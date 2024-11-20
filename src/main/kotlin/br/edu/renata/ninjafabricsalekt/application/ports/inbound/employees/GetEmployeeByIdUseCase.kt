package br.edu.renata.ninjafabricsalekt.application.ports.inbound.employees

import br.edu.renata.ninjafabricsalekt.application.domain.management.Employee

interface GetEmployeeByIdUseCase {
    fun execute(id: String): Employee
}