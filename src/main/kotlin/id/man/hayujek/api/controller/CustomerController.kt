package id.man.hayujek.api.controller

import id.man.hayujek.api.base.BaseResponse
import id.man.hayujek.api.entity.customer.CustomerLoginRequest
import id.man.hayujek.api.entity.customer.CustomerLoginResponse
import id.man.hayujek.api.entity.customer.CustomerRequest
import id.man.hayujek.api.entity.customer.CustomerRequest.Companion.mapNewCustomer
import id.man.hayujek.api.service.MainServices
import id.man.hayujek.extentions.toResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * Created by Lukmanul Hakim on  02/07/22
 * devs.lukman@gmail.com
 */
@RestController
@RequestMapping("v1/api/customer")
class CustomerController {

    @Autowired
    private lateinit var mainServices: MainServices

    @GetMapping("/hello")
    fun ping(): BaseResponse<String> =
        BaseResponse(
            message = "Success",
            data = "API Customer"
        )

    @PostMapping("/login")
    fun login(
        @RequestBody request : CustomerLoginRequest
    ) : BaseResponse<CustomerLoginResponse>{
        return mainServices.loginCustomer(request).toResponses()
    }

    @PostMapping("/register")
    fun register(
        @RequestBody request : CustomerRequest
    ) : BaseResponse<Boolean>{
        return mainServices.registerCustomer(request.mapNewCustomer()).toResponses()
    }

}