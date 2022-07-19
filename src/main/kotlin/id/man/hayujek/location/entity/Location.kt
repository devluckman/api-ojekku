package id.man.hayujek.location.entity

/**
 *
 * Created by Lukmanul Hakim on  19/07/22
 * devs.lukman@gmail.com
 */
data class Location (
    var name: String = "",
    var address: Address = Address(),
    var coordinate: Coordinate = Coordinate()
) {
    data class Address(
        var city: String = "",
        var country: String = "",
        var distric: String = ""
    )
}