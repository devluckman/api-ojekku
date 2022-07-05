package id.man.hayujek.api.controller

import id.man.hayujek.api.base.BaseResponse
import id.man.hayujek.api.entity.user.*
import id.man.hayujek.api.entity.user.UserRegisterRequest.Companion.toRegister
import id.man.hayujek.api.service.MainServices
import id.man.hayujek.extentions.toResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

/**
 *
 * Created by Lukmanul Hakim on  05/07/22
 * devs.lukman@gmail.com
 */
@RestController
@RequestMapping("v1/api")
class MainController {

    // region Initials Main Controller

    @Autowired
    private lateinit var mainServices: MainServices

    @GetMapping("/hello")
    fun ping(): BaseResponse<String> =
        BaseResponse(
            message = "Success",
            data = "New API Customer"
        )

    // endregion

    // region API Authentication Customer

    @PostMapping("/customer/login")
    fun login(
        @RequestBody request : UserLoginRequest
    ) : BaseResponse<UserLoginResponse>{
        return mainServices.login(
            request = request,
            role = UserEntity.ROLE_CUSTOMER
        ).toResponses()
    }

    @GetMapping("/customer/{name}")
    fun getCustomerByName(
        @PathVariable(value = "name") customerName: String
    ): BaseResponse<UserData> {
        return mainServices.getUserByUserName(
            userName = customerName,
            role = UserEntity.ROLE_CUSTOMER
        ).toResponses()
    }

    @GetMapping("/customer")
    fun getCustomer(
    ): BaseResponse<UserData> {
        val userId = SecurityContextHolder.getContext().authentication.principal as? String
        return mainServices.getUserById(
            id = userId.orEmpty(),
            role = UserEntity.ROLE_CUSTOMER
        ).toResponses()
    }


    @PostMapping("/customer/register")
    fun register(
        @RequestBody request : UserRegisterRequest
    ) : BaseResponse<Boolean>{
        return mainServices.register(request.toRegister()).toResponses()
    }

    // endregion

    // region API Authentication Driver

    @PostMapping("/driver/login")
    fun loginDriver(
        @RequestBody request : UserLoginRequest
    ) : BaseResponse<UserLoginResponse>{
        return mainServices.login(
            request = request,
            role = UserEntity.ROLE_DRIVER
        ).toResponses()
    }

    @GetMapping("/driver/{name}")
    fun getDriverByName(
        @PathVariable(value = "name") customerName: String
    ): BaseResponse<UserData> {
        return mainServices.getUserByUserName(
            userName = customerName,
            role = UserEntity.ROLE_DRIVER
        ).toResponses()
    }

    @GetMapping("/driver")
    fun getDriver(
    ): BaseResponse<UserData> {
        val userId = SecurityContextHolder.getContext().authentication.principal as? String
        return mainServices.getUserById(
            id = userId.orEmpty(),
            role = UserEntity.ROLE_DRIVER
        ).toResponses()
    }


    @PostMapping("/driver/register")
    fun registerDriver(
        @RequestBody request : UserRegisterRequest
    ) : BaseResponse<Boolean>{
        return mainServices.register(request.toRegister()).toResponses()
    }

    // endregion
}