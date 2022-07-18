package id.man.hayujek.core.database.entity

/**
 *
 * Created by Lukmanul Hakim on  05/07/22
 * devs.lukman@gmail.com
 */
data class UserEntity(
    val id: String,
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
        val ROLE_CUSTOMER = "customer"
        val ROLE_DRIVER = "driver"
    }

}