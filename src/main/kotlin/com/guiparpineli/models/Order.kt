package com.guiparpineli.models

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table


object Orders : Table("order") {
    val contents = reference("products",Products)
    val vendor = reference("vendor", Vendors.id)
    //val customer = reference("customer", Customer.id)
    override val primaryKey = PrimaryKey(contents, vendor, name = "PK_Orders")
}
