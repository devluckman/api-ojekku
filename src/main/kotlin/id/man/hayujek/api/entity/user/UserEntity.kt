package id.man.hayujek.api.entity.user

/**
 *
 * Created by Lukmanul Hakim on  05/07/22
 * devs.lukman@gmail.com
 */
data class UserEntity(
    val id: String,
    val username: String,
    var password: String?,
    val role: String = ROLE_CUSTOMER
) {

    companion object {

        val ROLE_CUSTOMER = "customer"
        val ROLE_DRIVER = "driver"
    }

}