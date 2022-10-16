package com.guiparpineli.models

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

class Customer(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Customer>(Customers)

    var cnpj by Customers.cnpj
    var razaoSocial by Customers.razaoSocial
    var email by Customers.email
    var password by Customers.password

}
