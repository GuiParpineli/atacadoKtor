package com.guiparpineli.routes


import com.guiparpineli.dao.impl.DAOFacadeCustomerImpl
import com.guiparpineli.models.Customer
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {

    val dao = DAOFacadeCustomerImpl()

    route("customer") {

        get { call.respond(dao.getAll()) }

        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Id nao presente na entidade cliente", status = HttpStatusCode.BadRequest
            )
            val customer = dao.getById(id.toInt()) ?: return@get call.respondText(
                "Nenhum cliente com o id informado", status = HttpStatusCode.NotFound
            )
            call.respond(customer)
        }

        post {
            val customer = call.receive<Customer>()
            dao.save(customer)
            call.respondText("Cliente salvo com sucesso", status = HttpStatusCode.Created)
        }

        put("{id?}") {
            val id = call.parameters["id"] ?: return@put call.respond(HttpStatusCode.BadRequest)
            val customer = call.receive<Customer>()
            if (dao.getById(id.toInt())!!.id == customer.id) dao.update(customer)
            call.respondText(
                "cliente ${customer.razaoSocial} atualizado com sucesso", status = HttpStatusCode.Accepted
            )
        }
        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (dao.delete(id.toInt())) {
                call.respondText("Usuario deletado com sucesso", status = HttpStatusCode.OK)
            } else {
                call.respondText("Falha ao excluir", status = HttpStatusCode.BadRequest)
            }
        }
    }
}

