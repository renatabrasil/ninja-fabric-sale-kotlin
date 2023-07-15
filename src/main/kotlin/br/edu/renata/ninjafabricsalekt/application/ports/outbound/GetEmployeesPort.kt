package br.edu.renata.ninjafabricsalekt.application.ports.outbound

import br.edu.renata.ninjafabricsalekt.application.domain.management.Employee

interface GetEmployeesPort {
    fun findAll(): List<Employee>
}