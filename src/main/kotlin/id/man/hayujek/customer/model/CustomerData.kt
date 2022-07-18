package id.man.hayujek.customer.model

import id.man.hayujek.core.database.entity.UserEntity

/**
 *
 * Created by Lukmanul Hakim on  17/07/22
 * devs.lukman@gmail.com
 */
data class CustomerData(
    val id: String,
    val username: String,
    val role: String,
    val location: Location
) {

    data class Location(
        val latitude: Double?,
        val longitude: Double?
    )

    companion object {

        fun UserEntity.toData() = CustomerData(
            id = this.id,
            username = this.username,
            role = this.role,
            location = Location(
                latitude = this.location?.latitude,
                longitude = this.location?.longitude
            )
        )

    }
}