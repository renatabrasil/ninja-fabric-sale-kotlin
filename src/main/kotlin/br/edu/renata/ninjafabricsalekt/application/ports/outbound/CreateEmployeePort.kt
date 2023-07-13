package br.edu.renata.ninjafabricsalekt.application.ports.outbound

import br.edu.renata.ninjafabricsalekt.application.domain.Employee

interface CreateEmployeePort {
    fun save(employee: Employee)
}