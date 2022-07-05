package id.man.hayujek.api.service

import id.man.hayujek.api.entity.user.UserData
import id.man.hayujek.api.entity.user.UserEntity
import id.man.hayujek.api.entity.user.UserLoginRequest
import id.man.hayujek.api.entity.user.UserLoginResponse

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */

interface MainServices {

    // region Customer

    fun login(request : UserLoginRequest, role : String): Result<UserLoginResponse>

    fun register(userEntity: UserEntity) : Result<Boolean>

    fun getUserById(id : String, role : String) : Result<UserData>

    fun getUserByUserName(userName : String, role : String) : Result<UserData>
    // endregion

}