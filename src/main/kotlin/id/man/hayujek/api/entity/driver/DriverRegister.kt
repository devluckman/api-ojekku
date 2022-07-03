package id.man.aej.ojekku.api.entity.driver

import id.man.hayujek.api.entity.driver.DriverEntity

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */
data class DriverRegister(
    val username: String,
    val password: String,
    val email: String,
    val phone_number: String,
    val vehicle: String,
    val number_vehicle: String
) {

    companion object {

        fun DriverRegister.mapNewDriver() = DriverEntity.createNewDriver(
            username = username,
            password = password,
            email = email,
            phone_number = phone_number,
            vehicle = vehicle,
            number_vehicle = number_vehicle
        )

    }

}