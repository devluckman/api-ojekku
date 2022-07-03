package id.man.hayujek.api.repository

import id.man.hayujek.api.entity.customer.CustomerEntity

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */

interface MainRepository {

    // region Driver

    fun loginDriver(request : Any): Result<Any>

    fun registerDriver(request : Any): Result<Any>

    fun getDriver(request : Any) : Result<Any>

    // endregion

    // region Customer

    fun loginCustomer(request : Any): Result<Any>

    fun registerCustomer(customerEntity : CustomerEntity) : Result<Boolean>

    fun getCustomerById(id : String) : Result<CustomerEntity>

    fun getCustomerByUserName(userName : String) : Result<CustomerEntity>

    // endregion
}