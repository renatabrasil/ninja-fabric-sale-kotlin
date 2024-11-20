package br.edu.renata.ninjafabricsalekt.application.services.employees

import br.edu.renata.ninjafabricsalekt.adapters.inbound.web.employees.requests.CreateEmployeeRequest
import br.edu.renata.ninjafabricsalekt.application.ports.inbound.employees.CreateEmployeeUseCase
import br.edu.renata.ninjafabricsalekt.application.ports.outbound.CreateEmployeePort
import org.springframework.stereotype.Service

@Service
class CreateEmployeeService(private val createEmployeePort: CreateEmployeePort) : CreateEmployeeUseCase {
    override fun execute(createEmployeeRequest: CreateEmployeeRequest) {
        createEmployeePort.save(createEmployeeRequest.toDomain())
    }
}