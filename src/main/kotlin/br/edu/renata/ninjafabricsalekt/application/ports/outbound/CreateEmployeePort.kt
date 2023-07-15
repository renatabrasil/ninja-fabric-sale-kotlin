package br.edu.renata.ninjafabricsalekt.application.ports.outbound

import br.edu.renata.ninjafabricsalekt.application.domain.management.Employee

interface CreateEmployeePort {
    fun save(employee: Employee)
}