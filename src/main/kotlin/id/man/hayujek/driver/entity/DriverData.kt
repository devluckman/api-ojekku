package id.man.hayujek.driver.entity

import id.man.hayujek.core.database.entity.UserEntity

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
data class DriverData (
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

        fun UserEntity.toData() = DriverData(
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