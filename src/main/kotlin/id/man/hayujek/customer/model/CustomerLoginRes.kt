package id.man.hayujek.customer.model

/**
 *
 * Created by Lukmanul Hakim on  18/07/22
 * devs.lukman@gmail.com
 */
data class CustomerLoginRes  (
    val token : String,
    val name : String,
    val role : String,
    val location: Location
) {
    data class Location(
        val latitude: Double?,
        val longitude: Double?
    )
}