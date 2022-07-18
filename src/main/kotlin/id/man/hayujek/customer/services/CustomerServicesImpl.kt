package id.man.hayujek.customer.services

import id.man.hayujek.core.authenticator.JwtConfig
import id.man.hayujek.core.database.entity.UserEntity
import id.man.hayujek.core.exception.MainException
import id.man.hayujek.core.repository.MainRepository
import id.man.hayujek.customer.model.CustomerData
import id.man.hayujek.customer.model.CustomerData.Companion.toData
import id.man.hayujek.customer.model.CustomerLogin
import id.man.hayujek.customer.model.CustomerLogin.Companion.invalidLocation
import id.man.hayujek.customer.model.CustomerLogin.Companion.invalidPassword
import id.man.hayujek.customer.model.CustomerLogin.Companion.isCustomer
import id.man.hayujek.customer.model.CustomerLoginRes
import id.man.hayujek.customer.model.CustomerRegister
import id.man.hayujek.customer.model.CustomerRegister.Companion.toEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * Created by Lukmanul Hakim on  17/07/22
 * devs.lukman@gmail.com
 */
@Service
class CustomerServicesImpl(
    @Autowired
    private val repository: MainRepository
) : CustomerServices {

    override fun login(request: CustomerLogin): Result<CustomerLoginRes> {
        val dataUser = repository.getUserByUserName(request.username)
        return dataUser.map {
            val token = JwtConfig.generateToken(it)
            when  {
                request.invalidPassword(it.password) -> throw MainException("Failed, password is incorrect")
                request.invalidLocation() -> throw MainException("Invalid locations")
                !it.role.isCustomer() -> throw MainException("User not found")
                else -> {
                    it.apply {
                        location = UserEntity.Location(
                            latitude = request.latitude,
                            longitude = request.longitude
                        )
                    }
                    repository.updateDataUser(it)
                    CustomerLoginRes(
                        token = token,
                        name = it.username,
                        role = it.role,
                        location = CustomerLoginRes.Location(
                            latitude = request.latitude,
                            longitude = request.longitude
                        )
                    )
                }
            }
        }
    }

    override fun register(request: CustomerRegister): Result<Boolean> {
        return repository.register(request.toEntity())
    }

    override fun getUserById(id: String): Result<CustomerData> {
        return repository.getUserById(id).map {
            if (it.role.isCustomer()){
                it.toData()
            } else throw MainException("Failed, user not found")
        }
    }

    override fun getUserByUserName(userName: String): Result<CustomerData> {
        return repository.getUserByUserName(userName).map {
            if (it.role.isCustomer()){
                it.toData()
            } else throw MainException("Failed, user not found")
        }
    }

}