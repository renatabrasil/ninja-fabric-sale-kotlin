package br.edu.renata.ninjafabricsalekt.application.usecases.employees

import br.edu.renata.ninjafabricsalekt.presentation.controllers.employees.requests.CreateEmployeeRequest

interface CreateEmployeeUseCase {
    fun execute(createEmployeeRequest: CreateEmployeeRequest)
}