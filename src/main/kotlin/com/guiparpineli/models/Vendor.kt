package com.guiparpineli.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Vendor(val id: Int, val name: String, val cpf: String, val comission: Int)

object Vendors : Table("vendor") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val cpf = char("cpf", 11).uniqueIndex()
    val comission = integer("comission")

    override val primaryKey = PrimaryKey(id)
}
