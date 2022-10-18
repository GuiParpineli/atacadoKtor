package com.guiparpineli.dao.impl

import com.guiparpineli.dao.repository.DAOFacade
import com.guiparpineli.models.Customer
import com.guiparpineli.models.CustomerEntity
import com.guiparpineli.models.Customers.cnpj
import com.guiparpineli.models.Customers.razaoSocial
import io.ktor.websocket.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DAOFacadeCustomeEntityImpl : DAOFacade<Customer> {

    override suspend fun getAll(): List<Customer> = transaction {
        CustomerEntity.all().map(CustomerEntity::toCustomer)
    }


    override suspend fun getById(id: Int): Customer = transaction {
        CustomerEntity[id].toCustomer()
    }

    override suspend fun update(e: Customer): Customer {
        TODO("Not yet implemented")
    }

    override suspend fun save(e: Customer) {
        CustomerEntity.new {
            cnpj = e.cnpj
            email = e.email
            password = e.password
            razaoSocial = e.razaoSocoal
        }
    }

    override suspend fun delete(id: Int) = transaction {
        TODO("Not yet implemented")
    }


}


val dao: DAOFacade<Customer> = DAOFacadeCustomeEntityImpl().apply {
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


