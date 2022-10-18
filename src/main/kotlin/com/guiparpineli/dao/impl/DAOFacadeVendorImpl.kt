package com.guiparpineli.dao.impl

import com.guiparpineli.dao.DatabaseFactory.dbQuery
import com.guiparpineli.dao.repository.DAOFacade
import com.guiparpineli.models.Customer
import com.guiparpineli.models.Vendor
import com.guiparpineli.models.Vendors
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.SizedIterable

class DAOFacadeVendorImpl : DAOFacade<Vendor> {
    override suspend fun getAll(): List<Vendor> {
        TODO("Not yet implemented")
    }


    override suspend fun getById(id: Int): Vendor? {
        TODO("Not yet implemented")
    }

    override suspend fun save(e: Vendor) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun update(Vendor: Vendor): Vendor {
        TODO("Not yet implemented")
    }



}