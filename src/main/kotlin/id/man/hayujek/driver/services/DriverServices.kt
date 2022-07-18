package id.man.hayujek.driver.services

import id.man.hayujek.driver.entity.DriverData
import id.man.hayujek.driver.entity.DriverLogin
import id.man.hayujek.driver.entity.DriverLoginRes
import id.man.hayujek.driver.entity.DriverRegister

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
interface DriverServices {

    fun login(request : DriverLogin): Result<DriverLoginRes>

    fun register(request: DriverRegister) : Result<Boolean>

    fun getUserById(id : String) : Result<DriverData>

    fun getUserByUserName(userName : String) : Result<DriverData>


}