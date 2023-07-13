package br.edu.renata.ninjafabricsalekt.application.ports.inbound.employees

import br.edu.renata.ninjafabricsalekt.adapters.inbound.web.employees.requests.CreateEmployeeRequest

interface CreateEmployeeUseCase {
    fun execute(createEmployeeRequest: CreateEmployeeRequest)
}