package com.guiparpineli.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Vendors : IntIdTable("vendor") {
    val name = varchar("name", 128)
    val cpf = char("cpf", 11).uniqueIndex()
    val comission = integer("comission")
}

class Vendor(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Vendor>(Vendors)

    var name by Vendors.name
    var cpf by Vendors.cpf
    var comission by Vendors.comission

}
