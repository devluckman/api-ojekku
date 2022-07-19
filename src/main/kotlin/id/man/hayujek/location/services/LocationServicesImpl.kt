package id.man.hayujek.location.services

import id.man.hayujek.core.extentions.orThrow
import id.man.hayujek.location.component.LocationComponent
import id.man.hayujek.location.entity.Coordinate
import id.man.hayujek.location.entity.Location
import id.man.hayujek.location.entity.Routes
import id.man.hayujek.location.mapper.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * Created by Lukmanul Hakim on  19/07/22
 * devs.lukman@gmail.com
 */
@Service
class LocationServicesImpl(
    @Autowired
    private val fetcher: LocationComponent
) : LocationServices {

    override fun searchLocation(name: String, coordinate: Coordinate, limit: Int): Result<List<Location>> {
        return fetcher.searchLocation(name, coordinate, limit).map {
            Mapper.mapSearchLocationHereToLocation(it)
        }
    }

    override fun reserveLocation(coordinate: Coordinate): Result<Location> {
        return fetcher.reserveLocation(coordinate).map {
            Mapper.mapSearchLocationHereToLocation(it).firstOrNull().orThrow("Location not found!")
        }
    }

    override fun getRoutesLocation(origin: Coordinate, destination: Coordinate): Result<Routes> {
        return fetcher.getRoutes(origin, destination).map {
            val coordinates = Mapper.mapRoutesHereToRoutes(it)
            Routes(coordinates)
        }
    }

}