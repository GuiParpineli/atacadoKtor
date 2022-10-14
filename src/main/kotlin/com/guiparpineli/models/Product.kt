package com.guiparpineli.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object Products : IntIdTable() {
    val name = varchar("name", 128)
    val ncm = varchar("ncm", 128)
    val category = varchar("category", 128)
    val inventory = integer("inventory")
    val pricePurchase = double("price_purchase")
    val price = double("price")
    val amount = integer("amount")
}

class Product(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Product>(Products)

    var name by Products.name
    var ncm by Products.ncm
    var category by Products.category
    var inventory by Products.inventory
    var pricePurchase by Products.inventory
    var price by Products.inventory
    var amount by Products.amount
}

