package br.edu.renata.ninjafabricsalekt.application.models

import java.util.*

data class Customer(
    val id: String = UUID.randomUUID().toString(),
    val completeName: String,
    val cnpj: String,
    val bankAccount: List<BankAccount>,
    val address: Address,
    val phones: List<Phone>,
    val emails: List<String>
    // Link para sistema financeiro para ver se o cliente consegue pagar
) {
    data class Address (
        val number: String,
        val neighborhood: String,
        val street: String,
        val complement: String,
        val city: String,
        val uf: String,
        val country: String,
        val zipCode: String
    )

    data class BankAccount(
        val number: String,
        val branch: String,
        val ispb: String
    )

    data class Phone(
        val number: Long,
        val ddd: Int,
        val ddi: Int,
        val type: PhoneType
    ) {
        enum class PhoneType {
            MOBILE,
            COMERCIAL,
            INVOICE
        }

    }

}
