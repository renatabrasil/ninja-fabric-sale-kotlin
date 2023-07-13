package br.edu.renata.ninjafabricsalekt.application.ports.outbound

import br.edu.renata.ninjafabricsalekt.application.domain.Employee

interface GetEmployeeByIdPort {
    fun findById(id: String): Employee
}