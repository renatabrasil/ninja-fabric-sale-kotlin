package br.edu.renata.ninjafabricsalekt.application.usecases.employees

import br.edu.renata.ninjafabricsalekt.application.models.Employee

interface GetEmployeeByIdUseCase {
    fun execute(id: String): Employee
}