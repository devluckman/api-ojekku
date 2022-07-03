package id.man.hayujek.api.service

import id.man.hayujek.api.entity.customer.CustomerEntity
import id.man.hayujek.api.entity.customer.CustomerLoginRequest
import id.man.hayujek.api.entity.customer.CustomerLoginResponse
import id.man.hayujek.api.repository.MainRepository
import id.man.hayujek.exception.MainException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */

@Service
class MainServicesImpl(
    @Autowired
    private val mainRepository: MainRepository
) : MainServices {

    override fun loginCustomer(request: CustomerLoginRequest): Result<CustomerLoginResponse> {
        val data = mainRepository.getCustomerByUserName(request.username)
        return if (data.isSuccess) {
            Result.success(CustomerLoginResponse(("token")))
        } else throw MainException("login failed")
    }

    override fun registerCustomer(customerEntity: CustomerEntity): Result<Boolean> {
        return mainRepository.registerCustomer(customerEntity)
    }

    override fun getCustomerById(id: String): Result<CustomerEntity> {
        return mainRepository.getCustomerById(id)
    }

    override fun getCustomerByUserName(userName: String): Result<CustomerEntity> {
        return mainRepository.getCustomerByUserName(userName)
    }


}