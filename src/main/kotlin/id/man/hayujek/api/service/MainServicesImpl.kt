package id.man.hayujek.api.service

import id.man.hayujek.api.entity.user.UserData
import id.man.hayujek.api.entity.user.UserEntity
import id.man.hayujek.api.entity.user.UserLoginRequest
import id.man.hayujek.api.entity.user.UserLoginResponse
import id.man.hayujek.api.repository.MainRepository
import id.man.hayujek.authenticator.JwtConfig
import id.man.hayujek.exception.MainException
import org.springframework.beans.factory.annotation.Autowired
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

    // region API Membership

    override fun login(request: UserLoginRequest, role: String): Result<UserLoginResponse> {
        val data = mainRepository.getUserByUserName(request.username)
        return data.map {
            val token = JwtConfig.generateToken(it)
            val passwordInDb = it.password
            val passwordRequest = request.password
            if (passwordInDb == passwordRequest && it.role == role) {
                UserLoginResponse(
                    token = token,
                    name = it.username,
                    role = it.role
                )
            } else {
                throw MainException("Failed, please check username and password!")
            }
        }
    }

    override fun register(userEntity: UserEntity): Result<Boolean> {
        return mainRepository.register(userEntity)
    }

    override fun getUserById(id: String, role: String): Result<UserData> {
        return mainRepository.getUserById(id).map {
            if (it.role == role){
                UserData(
                    id = it.id,
                    username = it.username,
                    role = it.role
                )
            } else throw MainException("Failed, user not found")
        }
    }

    override fun getUserByUserName(userName: String, role: String): Result<UserData> {
        return mainRepository.getUserByUserName(userName).map {
            if (it.role == role){
                UserData(
                    id = it.id,
                    username = it.username,
                    role = it.role
                )
            } else throw MainException("Failed, user not found")
        }
    }


    // endregion


}