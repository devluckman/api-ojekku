package id.man.hayujek.api.service

import id.man.hayujek.api.entity.customer.CustomerEntity
import id.man.hayujek.api.entity.customer.CustomerLoginRequest
import id.man.hayujek.api.entity.customer.CustomerLoginResponse

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */

interface MainServices {

    // region Customer

    fun loginCustomer(request : CustomerLoginRequest): Result<CustomerLoginResponse>

    fun registerCustomer(customerEntity : CustomerEntity) : Result<Boolean>

    fun getCustomerById(id : String) : Result<CustomerEntity>

    fun getCustomerByUserName(userName : String) : Result<CustomerEntity>

    // endregion

}