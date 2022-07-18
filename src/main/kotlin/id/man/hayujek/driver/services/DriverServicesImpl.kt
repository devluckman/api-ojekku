package id.man.hayujek.driver.services

import id.man.hayujek.core.authenticator.JwtConfig
import id.man.hayujek.core.database.entity.UserEntity
import id.man.hayujek.core.exception.MainException
import id.man.hayujek.core.repository.MainRepository
import id.man.hayujek.driver.entity.DriverData
import id.man.hayujek.driver.entity.DriverData.Companion.toData
import id.man.hayujek.driver.entity.DriverLogin
import id.man.hayujek.driver.entity.DriverLogin.Companion.invalidLocation
import id.man.hayujek.driver.entity.DriverLogin.Companion.invalidPassword
import id.man.hayujek.driver.entity.DriverLogin.Companion.isDriver
import id.man.hayujek.driver.entity.DriverLoginRes
import id.man.hayujek.driver.entity.DriverRegister
import id.man.hayujek.driver.entity.DriverRegister.Companion.toEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
@Service
class DriverServicesImpl(
    @Autowired
    private val repository: MainRepository
) : DriverServices{


    override fun login(request: DriverLogin): Result<DriverLoginRes> {
        val data = repository.getUserByUserName(request.username)
        return data.map {
            val token = JwtConfig.generateToken(it)
            when  {
                request.invalidPassword(it.password) -> throw MainException("Failed, password is incorrect")
                request.invalidLocation() -> throw MainException("Invalid locations")
                !it.role.isDriver() -> throw MainException("Driver not found")
                else -> {
                    it.apply {
                        location = UserEntity.Location(
                            latitude = request.latitude,
                            longitude = request.longitude
                        )
                    }
                    repository.updateDataUser(it)
                    DriverLoginRes(
                        token = token,
                        name = it.username,
                        role = it.role
                    )
                }
            }
        }
    }

    override fun register(request: DriverRegister): Result<Boolean> {
        return repository.register(request.toEntity())
    }

    override fun getUserById(id: String): Result<DriverData> {
        return repository.getUserById(id).map {
            if (it.role.isDriver()){
                it.toData()
            } else throw MainException("Failed, driver not found")
        }
    }

    override fun getUserByUserName(userName: String): Result<DriverData> {
        return repository.getUserByUserName(userName).map {
            if (it.role.isDriver()){
                it.toData()
            } else throw MainException("Failed, driver not found")
        }
    }


}