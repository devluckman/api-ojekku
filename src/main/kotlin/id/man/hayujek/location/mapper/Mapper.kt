package id.man.hayujek.location.mapper

import id.man.hayujek.PolylineEncoderDecoder
import id.man.hayujek.location.entity.Coordinate
import id.man.hayujek.location.entity.Location
import id.man.hayujek.location.entity.LocationHereApiResult
import id.man.hayujek.location.entity.LocationHereRouteResult

/**
 *
 * Created by Lukmanul Hakim on  19/07/22
 * devs.lukman@gmail.com
 */
object Mapper {

    fun mapSearchLocationHereToLocation(locationResult: LocationHereApiResult): List<Location> {
        return locationResult.items?.map {
            val address = Location.Address(
                city = it?.address?.city.orEmpty(),
                country = it?.address?.countryName.orEmpty(),
                distric = it?.address?.district.orEmpty()
            )
            Location(
                name = it?.title.orEmpty(),
                address = address,
                coordinate = Coordinate(it?.position?.lat ?: 0.0, it?.position?.lng ?: 0.0)
            )
        }.orEmpty()
    }

    fun mapRoutesHereToRoutes(locationResult: LocationHereRouteResult): List<Coordinate> {
        val polylineString = locationResult.routes
            ?.firstOrNull()
            ?.sections
            ?.firstOrNull()
            ?.polyline
            .orEmpty()

        return PolylineEncoderDecoder.decode(polylineString)
            .map { Coordinate(it.lat, it.lng) }
    }

}