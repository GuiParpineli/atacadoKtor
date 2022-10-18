package com.guiparpineli.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable


object Customers : IntIdTable("customer") {
    val cnpj = varchar("cnpj", 128)
    val razaoSocial = varchar("razao_social", 128)
    val email = varchar("email", 128)
    val password = varchar("password", 128)

}

class CustomerEntity(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<CustomerEntity>(Customers)

    var cnpj by Customers.cnpj
    var razaoSocial by Customers.razaoSocial
    var email by Customers.email
    var password by Customers.password

    fun toCustomer() = Customer(id.value, cnpj, razaoSocial, email, password)

}

@Serializable
data class Customer(val id: Int, val cnpj: String, val razaoSocoal: String, val email: String, val password: String)