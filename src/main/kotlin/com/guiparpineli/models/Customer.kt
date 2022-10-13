package com.guiparpineli.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Customer(val id: Int, val cnpj: String, val razaoSocial: String, val email: String, val password: String)

object Customers : Table("customer") {
    val id = integer("id").autoIncrement()
    val cnpj = varchar("cnpj", 128)
    val razaoSocial = varchar("razao_social", 128)
    val email = varchar("email", 128)
    val password = varchar("password", 128)

    override val primaryKey  = PrimaryKey(id)
}
