package br.edu.renata.ninjafabricsalekt.application.services

import br.edu.renata.ninjafabricsalekt.application.domain.Employee
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.employees.GetEmployeeByIdUseCase
import br.edu.renata.ninjafabricsalekt.application.ports.outbound.GetEmployeeByIdPort
import org.springframework.stereotype.Service

@Service
class GetEmployeeByIdService(private val getEmployeeByIdPort: GetEmployeeByIdPort) : GetEmployeeByIdUseCase {
    override fun execute(id: String): Employee {
        return getEmployeeByIdPort.findById(id)
    }
}