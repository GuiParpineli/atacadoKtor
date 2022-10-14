package com.guiparpineli.models

import org.jetbrains.exposed.sql.Table

data class Order(val id: Int, val contents: List<Product>, val vendor: Vendor, val customer: Customer)

object Orders : Table("order") {
    val id = integer("id").autoIncrement()
}