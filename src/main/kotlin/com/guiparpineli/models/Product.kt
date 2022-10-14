package com.guiparpineli.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Product(
    val id: Int, val name: String, val ncm: String, val category: String, val inventory: Int, val
    pricePurchase: Double, val price: Double, val amount: Int
)

object Products : Table("product") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val ncm = varchar("ncm", 128)
    val category = varchar("category", 128)
    val inventory = integer("inventory")
    val pricePurchase = double("price_purchase")
    val price = double("price")
    val amount = integer("amount")

    override val primaryKey = PrimaryKey(id)
}
