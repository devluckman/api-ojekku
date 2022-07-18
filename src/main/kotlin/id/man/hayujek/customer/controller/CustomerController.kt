package id.man.hayujek.customer.controller

import id.man.hayujek.core.base.BaseResponse
import id.man.hayujek.core.extentions.toResponses
import id.man.hayujek.customer.model.CustomerData
import id.man.hayujek.customer.model.CustomerLogin
import id.man.hayujek.customer.model.CustomerLoginRes
import id.man.hayujek.customer.model.CustomerRegister
import id.man.hayujek.customer.services.CustomerServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

/**
 *
 * Created by Lukmanul Hakim on  17/07/22
 * devs.lukman@gmail.com
 */
@RestController
@RequestMapping("v1/api/customer")
class CustomerController {

    // region Initials Customer Controller

    @Autowired
    private lateinit var services: CustomerServices

    @GetMapping("/hello")
    fun ping(): BaseResponse<String> =
        BaseResponse(
            message = "Success",
            data = "New API Customer"
        )

    // endregion

    // region API Authentication Customer

    @PostMapping("/login")
    fun login(
        @RequestBody request : CustomerLogin
    ) : BaseResponse<CustomerLoginRes> {
        return services.login(
            request = request
        ).toResponses()
    }

    @PostMapping("register")
    fun register(
        @RequestBody request : CustomerRegister
    ) : BaseResponse<Boolean> {
        return services.register(request).toResponses()
    }

    @GetMapping("/{name}")
    fun getCustomerByName(
        @PathVariable(value = "name") customerName: String
    ): BaseResponse<CustomerData> {
        return services.getUserByUserName(
            userName = customerName
        ).toResponses()
    }

    @GetMapping
    fun getCustomerByToken(
    ): BaseResponse<CustomerData> {
        val userId = SecurityContextHolder.getContext().authentication.principal as? String
        return services.getUserById(
            id = userId.orEmpty()
        ).toResponses()
    }

    // endregion

}