package id.man.hayujek.core.repository

import id.man.hayujek.core.database.entity.UserEntity

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */

interface MainRepository {

    // region Customer
    fun register(userEntity: UserEntity) : Result<Boolean>

    fun updateDataUser(userEntity: UserEntity)

    fun getUserById(id : String) : Result<UserEntity>

    fun getUserByUserName(userName : String) : Result<UserEntity>

    // endregion
}