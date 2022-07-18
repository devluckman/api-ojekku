package id.man.hayujek.customer.model

import id.man.hayujek.core.database.entity.UserEntity
import id.man.hayujek.core.Constants.ROLE_CUSTOMER
import java.util.*

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
data class CustomerRegister(
    val username: String,
    var password: String?,
    val role: String = ROLE_CUSTOMER,
    var location: Location? = null
) {
    data class Location(
        val latitude: Double?,
        val longitude: Double?
    )

    companion object {

        fun CustomerRegister.toEntity() = UserEntity(
            id = UUID.randomUUID().toString(),
            username = username,
            password = password,
            role = role,
            location = UserEntity.Location(
                latitude = location?.latitude ?: 0.0,
                longitude = location?.longitude ?: 0.0
            )
        )

    }
}