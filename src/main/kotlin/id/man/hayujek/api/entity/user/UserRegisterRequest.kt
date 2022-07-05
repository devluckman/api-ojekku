package id.man.hayujek.api.entity.user

import java.util.*

/**
 *
 * Created by Lukmanul Hakim on  05/07/22
 * devs.lukman@gmail.com
 */
data class UserRegisterRequest(
    var username: String,
    var password: String,
){

    companion object {

        fun UserRegisterRequest.toRegister() = UserEntity(
            id = UUID.randomUUID().toString(),
            username = username,
            password = password
        )

    }

}