package com.guiparpineli.dao.repository

interface DAOFacade<T> {
    suspend fun getAll(): List<T>
    suspend fun getById(id: Int): T?
    suspend fun save(e: T)
    suspend fun update(e: T): T
    suspend fun delete(id: Int): Boolean
}