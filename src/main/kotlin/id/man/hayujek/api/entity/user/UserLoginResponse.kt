package id.man.hayujek.api.entity.user

/**
 *
 * Created by Lukmanul Hakim on  05/07/22
 * devs.lukman@gmail.com
 */
data class UserLoginResponse (
    val token : String,
    val name : String,
    val role : String
        )