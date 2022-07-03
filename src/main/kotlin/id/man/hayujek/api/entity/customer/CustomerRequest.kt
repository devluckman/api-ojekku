package id.man.hayujek.api.entity.customer

import java.util.*

/**
 *
 * Created by Lukmanul Hakim on  03/07/22
 * devs.lukman@gmail.com
 */
data class CustomerRequest(
    val username: String,
    val password: String
) {
    companion object {
        fun CustomerRequest.mapNewCustomer(): CustomerEntity {
            return CustomerEntity(
                id = UUID.randomUUID().toString(),
                username = username,
                password = password
            )
        }
    }
}