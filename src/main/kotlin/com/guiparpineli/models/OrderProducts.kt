package com.guiparpineli.models

import org.jetbrains.exposed.sql.Table

object OrderProducts : Table() {
    val order = reference("order", Orders)
    val products = reference("product", Products)
    val vendor = reference("vendor", Vendors)
    val customer = reference("customer", Customers)
    override val primaryKey = PrimaryKey(vendor, customer, name = "PK_Orders")
}