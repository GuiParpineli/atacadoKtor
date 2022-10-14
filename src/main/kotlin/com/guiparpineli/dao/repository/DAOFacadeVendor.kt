package com.guiparpineli.dao.repository

import com.guiparpineli.models.Vendor

interface DAOFacadeVendor {
    suspend fun getAll(): List<Vendor>
    suspend fun getById(id: Int): Vendor?
    suspend fun save(Vendor: Vendor): Vendor?
    suspend fun update(Vendor: Vendor): Boolean
    suspend fun delete(id: Int): Boolean
}