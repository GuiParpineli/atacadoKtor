package com.guiparpineli.models

import org.jetbrains.exposed.sql.Table

object OrderProducts : Table() {
    val order = reference("order", Orders)
    val products = reference("product", Products)
    override val primaryKey = PrimaryKey(order, name = "PK_Orders")
}