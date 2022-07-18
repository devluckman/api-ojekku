package id.man.hayujek.customer.model

import id.man.hayujek.core.Constants.ROLE_CUSTOMER

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
data class CustomerLogin(
    var username: String,
    var password: String,
    var latitude: Double? = null,
    var longitude: Double? = null,
) {

    companion object {

        fun CustomerLogin.invalidLocation() = latitude == null && longitude == null

        fun CustomerLogin.invalidPassword(password: String?) = this.password != password

        fun String.isCustomer() = this == ROLE_CUSTOMER

    }

}