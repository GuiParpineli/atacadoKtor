package com.guiparpineli.dao.impl

import com.guiparpineli.dao.DatabaseFactory.dbQuery
import com.guiparpineli.dao.repository.DAOFacadeCustomer
import com.guiparpineli.models.Customer
import com.guiparpineli.models.Customers
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*

class DAOFacadeCustomerImpl : DAOFacadeCustomer {

    private fun resultRowToCustomer(row: ResultRow) = Customer(
        id = row[Customers.id],
        cnpj = row[Customers.cnpj],
        razaoSocial = row[Customers.razaoSocial],
        email = row[Customers.email],
        password = row[Customers.password],
    )

    override suspend fun getAll(): List<Customer> = dbQuery {
        Customers.selectAll().map(::resultRowToCustomer)
    }

    override suspend fun getById(id: Int): Customer? = dbQuery {
        Customers
            .select { Customers.id eq id }
            .map(::resultRowToCustomer)
            .singleOrNull()
    }

    override suspend fun save(customer: Customer): Customer? =
        dbQuery {
            val insertStatement = Customers.insert {
                it[cnpj] = customer.cnpj
                it[razaoSocial] = customer.razaoSocial
                it[email] = customer.email
                it[password] = customer.password
            }
            insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToCustomer)
        }

    override suspend fun update(customer: Customer): Boolean =
        dbQuery {
            Customers.update({ Customers.id eq customer.id }) {
                it[cnpj] = customer.cnpj
                it[razaoSocial] = customer.razaoSocial
                it[email] = customer.email
                it[password] = customer.password
            } > 0
        }

    override suspend fun delete(id: Int): Boolean = dbQuery {
        Customers.deleteWhere { Customers.id eq id } > 0
    }

}

val dao: DAOFacadeCustomer = DAOFacadeCustomerImpl().apply {
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

