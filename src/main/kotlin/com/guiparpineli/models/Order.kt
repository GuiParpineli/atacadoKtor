package com.guiparpineli.models

import com.guiparpineli.models.Customers.reference
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Orders : IntIdTable() {

}

class Order(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Order>(Orders)
    val vendor = reference("vendor", Vendors)
    val customer = reference("customer", Customers)
    var products by Product via OrderProducts
}
