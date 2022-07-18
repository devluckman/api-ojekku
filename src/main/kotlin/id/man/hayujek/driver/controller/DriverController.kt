package id.man.hayujek.driver.controller

import id.man.hayujek.core.base.BaseResponse
import id.man.hayujek.core.extentions.toResponses
import id.man.hayujek.driver.entity.DriverData
import id.man.hayujek.driver.entity.DriverLogin
import id.man.hayujek.driver.entity.DriverLoginRes
import id.man.hayujek.driver.entity.DriverRegister
import id.man.hayujek.driver.services.DriverServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
@RestController
@RequestMapping("v1/api/driver")
class DriverController {

    @Autowired
    private lateinit var mainServices: DriverServices

    @PostMapping("/login")
    fun loginDriver(
        @RequestBody request: DriverLogin
    ): BaseResponse<DriverLoginRes> {
        return mainServices.login(
            request = request
        ).toResponses()
    }

    @GetMapping("{name}")
    fun getDriverByName(
        @PathVariable(value = "name") name: String
    ): BaseResponse<DriverData> {
        return mainServices.getUserByUserName(
            userName = name
        ).toResponses()
    }

    @GetMapping
    fun getDriver(
    ): BaseResponse<DriverData> {
        val userId = SecurityContextHolder.getContext().authentication.principal as? String
        return mainServices.getUserById(
            id = userId.orEmpty()
        ).toResponses()
    }


    @PostMapping("/register")
    fun registerDriver(
        @RequestBody request: DriverRegister
    ): BaseResponse<Boolean> {
        return mainServices.register(request).toResponses()
    }

}