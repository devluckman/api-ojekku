package id.man.hayujek.driver.entity

import id.man.hayujek.core.database.entity.UserEntity
import id.man.hayujek.core.Constants
import java.util.*

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
data class DriverRegister (
    val username: String,
    var password: String?,
    val role: String = Constants.ROLE_DRIVER,
    var location: Location? = null
) {
    data class Location(
        val latitude: Double?,
        val longitude: Double?
    )

    companion object {

        fun DriverRegister.toEntity() = UserEntity(
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