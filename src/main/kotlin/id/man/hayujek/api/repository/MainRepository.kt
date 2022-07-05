package id.man.hayujek.api.repository

import id.man.hayujek.api.entity.user.UserEntity

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */

interface MainRepository {

    // region Customer
    fun register(userEntity: UserEntity) : Result<Boolean>

    fun getUserById(id : String) : Result<UserEntity>

    fun getUserByUserName(userName : String) : Result<UserEntity>

    // endregion
}