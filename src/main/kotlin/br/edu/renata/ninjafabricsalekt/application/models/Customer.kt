package br.edu.renata.ninjafabricsalekt.application.models

import java.util.*
import javax.persistence.*

@Entity
data class Customer(

    @Id
    val id: String = UUID.randomUUID().toString(),

    @Column(name = "complete_name")
    val completeName: String,
    val cnpj: String,

    @OneToMany(mappedBy = "id", cascade = [CascadeType.ALL])
    @Column(name = "bank_account")
    val bankAccount: List<BankAccount>,

    @OneToOne(cascade = [CascadeType.ALL])
    val address: Address,
//    val phones: List<Phone>,
//    val emails: List<String>
    // Link para sistema financeiro para ver se o cliente consegue pagar
) {
    @Entity
    data class Address (
        @Id
        val id: String,
        val number: String,
        val neighborhood: String,
        val street: String,
        val complement: String,
        val city: String,
        val uf: String,
        val country: String,
        val zipCode: String
    )

    @Entity
    data class BankAccount(
        @Id
        val id: String,
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
