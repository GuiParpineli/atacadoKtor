package com.guiparpineli.dao.impl

import com.guiparpineli.dao.repository.DAOFacadeVendor
import com.guiparpineli.models.Vendor
import com.guiparpineli.models.Vendors
import org.jetbrains.exposed.sql.ResultRow

class DAOFacadeVendorImpl : DAOFacadeVendor {

    private fun resultRowToVendor(row: ResultRow) = Vendor(
        id = row[Vendors.id],
        name = row[Vendors.name],
        cpf = row[Vendors.cpf],
        comission = row[Vendors.comission]
    )


    override suspend fun getAll(): List<Vendor> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Int): Vendor? {
        TODO("Not yet implemented")
    }

    override suspend fun save(Vendor: Vendor): Vendor? {
        TODO("Not yet implemented")
    }

    override suspend fun update(Vendor: Vendor): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}