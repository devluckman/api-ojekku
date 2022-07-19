package id.man.hayujek.location.controller

import id.man.hayujek.core.base.BaseResponse
import id.man.hayujek.core.extentions.coordinateStringToData
import id.man.hayujek.core.extentions.toResponses
import id.man.hayujek.location.entity.Location
import id.man.hayujek.location.entity.Routes
import id.man.hayujek.location.services.LocationServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 *
 * Created by Lukmanul Hakim on  19/07/22
 * devs.lukman@gmail.com
 */
@RestController
@RequestMapping("v1/api/location")
class LocationController {

    @Autowired
    private lateinit var locationServices: LocationServices

    @GetMapping("/search")
    fun searchLocation(
        @RequestParam(value = "name", required = true) name: String,
        @RequestParam(value = "limit", required = false) limit: Int = 20,
        @RequestParam(value = "coordinate", required = true) coordinate: String
    ): BaseResponse<List<Location>> {
        val coordinateData = coordinate.coordinateStringToData()
        return locationServices.searchLocation(name, coordinateData,limit).toResponses()
    }

    @GetMapping("/reserve")
    fun reserveLocation(
        @RequestParam(value = "coordinate", required = true) coordinate: String
    ): BaseResponse<Location> {
        val coordinateData = coordinate.coordinateStringToData()
        return locationServices.reserveLocation(coordinateData).toResponses()
    }

    @GetMapping("/routes")
    fun routesLocation(
        @RequestParam(value = "origin") origin: String,
        @RequestParam(value = "destination") destination: String
    ): BaseResponse<Routes> {
        val coordinateOrigin = origin.coordinateStringToData()
        val coordinateDestination = destination.coordinateStringToData()
        return locationServices.getRoutesLocation(coordinateOrigin, coordinateDestination).toResponses()
    }

}
