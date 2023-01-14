package com.guiparpineli.dao.impl

import com.guiparpineli.dao.DatabaseFactory.dbQuery
import com.guiparpineli.dao.repository.DAOFacade
import com.guiparpineli.models.Customer
import com.guiparpineli.models.CustomerEntity
import com.guiparpineli.models.Customers

import kotlinx.coroutines.runBlocking

import org.jetbrains.exposed.sql.transactions.transaction

class DAOFacadeCustomerImpl : DAOFacade<Customer> {

    override suspend fun getAll(): List<Customer> = dbQuery {
        CustomerEntity.all().map(CustomerEntity::toCustomer)
    }


    override suspend fun getById(id: Int): Customer = dbQuery {
        CustomerEntity[id].toCustomer()
    }

    override suspend fun update(e: Customer): Customer = dbQuery {
        TODO()
    }

    override suspend fun save(e: Customer): Unit = dbQuery{
        CustomerEntity.new {
            cnpj = e.cnpj
            email = e.email
            password = e.password
            razaoSocial = e.razaoSocial
        }
    }

    override suspend fun delete(id: Int) = dbQuery {
        CustomerEntity[id].delete()
        return@dbQuery true
    }


}


val dao: DAOFacade<Customer> = DAOFacadeCustomerImpl().apply {
    runBlocking {
        if (getAll().isEmpty()) {
            save(
                Customer(
                    1,
                    "77.446.323-0001-32",
                    "Loja 1 real",
                    "loja1real@email.com",
                    "1234"
                )
            )
        }
    }
}


