package id.man.hayujek.api.entity.driver

import java.util.*

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */

data class DriverEntity(
    val id : String,
    val username: String,
    val password: String,
    val email: String,
    val phone_number: String,
    val vehicle: String,
    val number_vehicle: String
) {

    companion object {
        fun createNewDriver(
            username: String,
            password: String,
            email: String,
            vehicle: String,
            phone_number: String,
            number_vehicle: String
        ) = DriverEntity(
            id = UUID.randomUUID().toString(),
            username = username,
            password = password,
            email = email,
            phone_number = phone_number,
            vehicle = vehicle,
            number_vehicle = number_vehicle
        )
    }

}