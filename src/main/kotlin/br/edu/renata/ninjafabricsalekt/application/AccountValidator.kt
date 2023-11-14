package br.edu.renata.ninjafabricsalekt.application

import br.edu.renata.ninjafabricsalekt.application.services.employees.GetEmployeeByIdService

class AccountValidator(
    private val getEmployeeByIdService: GetEmployeeByIdService
): InstanceValidator {
    override fun validate(): Boolean {

        println(getEmployeeByIdService.execute("1"))

        print("executa validação")

        return true

//        TODO("Not yet implemented")
    }
}