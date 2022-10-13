package com.guiparpineli.dao

import com.guiparpineli.models.Customer

interface DAOFacadeCustomer {
    suspend fun getAll(): List<Customer>
    suspend fun getById(id: Int): Customer?
    suspend fun save(customer: Customer): Customer?
    suspend fun update(customer: Customer): Boolean
    suspend fun delete(id: Int): Boolean
}