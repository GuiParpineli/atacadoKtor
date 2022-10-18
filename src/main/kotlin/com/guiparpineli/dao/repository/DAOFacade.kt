package com.guiparpineli.dao.repository

import com.guiparpineli.models.Customer
import com.guiparpineli.models.Vendor
import org.jetbrains.exposed.sql.SizedIterable

interface DAOFacade<T> {
    suspend fun getAll(): List<T>
    suspend fun getById(id: Int): T?
    suspend fun save(e: T)
    suspend fun update(e: T): T
    suspend fun delete(id: Int): Boolean
}