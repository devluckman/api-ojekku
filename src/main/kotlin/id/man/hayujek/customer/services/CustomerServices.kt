package id.man.hayujek.customer.services

import id.man.hayujek.customer.model.CustomerData
import id.man.hayujek.customer.model.CustomerLogin
import id.man.hayujek.customer.model.CustomerLoginRes
import id.man.hayujek.customer.model.CustomerRegister

/**
 *
 * Created by Lukmanul Hakim on  17/07/22
 * devs.lukman@gmail.com
 */
interface CustomerServices {
    
    fun login(request : CustomerLogin): Result<CustomerLoginRes>

    fun register(request: CustomerRegister) : Result<Boolean>

    fun getUserById(id : String) : Result<CustomerData>

    fun getUserByUserName(userName : String) : Result<CustomerData>

}