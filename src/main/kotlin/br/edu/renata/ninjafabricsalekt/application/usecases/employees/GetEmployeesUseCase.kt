package br.edu.renata.ninjafabricsalekt.application.usecases.employees

import br.edu.renata.ninjafabricsalekt.application.models.Employee

interface GetEmployeesUseCase {
    fun execute(): List<Employee>
}