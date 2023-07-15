package br.edu.renata.ninjafabricsalekt.application.services.employees

import br.edu.renata.ninjafabricsalekt.application.ports.inbound.employees.GetEmployeesUseCase
import br.edu.renata.ninjafabricsalekt.application.ports.outbound.GetEmployeesPort
import org.springframework.stereotype.Service

@Service
class GetEmployeesService(private val getEmployeesPort: GetEmployeesPort) : GetEmployeesUseCase {
    override fun execute() = getEmployeesPort.findAll()
}