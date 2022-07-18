package id.man.hayujek.driver.entity

import id.man.hayujek.core.Constants
import id.man.hayujek.customer.model.CustomerLogin

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
data class DriverLogin (
    var username: String,
    var password: String,
    var latitude: Double? = null,
    var longitude: Double? = null,
) {

    companion object {

        fun DriverLogin.invalidLocation() = latitude == null && longitude == null

        fun DriverLogin.invalidPassword(password: String?) = this.password != password

        fun String.isDriver() = this == Constants.ROLE_DRIVER

    }

}