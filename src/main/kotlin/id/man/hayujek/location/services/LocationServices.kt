package id.man.hayujek.location.services

import id.man.hayujek.location.entity.Coordinate
import id.man.hayujek.location.entity.Location
import id.man.hayujek.location.entity.Routes

/**
 *
 * Created by Lukmanul Hakim on  19/07/22
 * devs.lukman@gmail.com
 */
interface LocationServices {

    fun searchLocation(name: String, coordinate: Coordinate, limit : Int): Result<List<Location>>

    fun reserveLocation(coordinate: Coordinate): Result<Location>

    fun getRoutesLocation(origin: Coordinate, destination: Coordinate): Result<Routes>

}