package id.man.hayujek.location.component

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException
import id.man.hayujek.location.entity.Coordinate
import id.man.hayujek.location.entity.LocationHereApiResult
import id.man.hayujek.location.entity.LocationHereRouteResult
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Component

/**
 *
 * Created by Lukmanul Hakim on  19/07/22
 * devs.lukman@gmail.com
 */
@Component
class LocationComponent {

    // region Initialize OKHttpClient

    private val client = OkHttpClient()

    private inline fun <reified T> getHttp(url: String): Result<T> {
        return try {
            val request = Request.Builder()
                .url(url)
                .build()

            val response = client.newCall(request).execute()
            val body = response.body
            val bodyString = body?.string()
            if (response.isSuccessful) {
                val data = ObjectMapper().readValue(bodyString, T::class.java)
                Result.success(data)
            } else {
                val throwable = IllegalArgumentException(response.message)
                Result.failure(throwable)
            }
        } catch (e: JsonParseException) {
            Result.failure(e)
        } catch (e: InvalidDefinitionException) {
            Result.failure(e)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }

    // endregion

    // region services here api

    fun searchLocation(name: String, coordinate: Coordinate, limit : Int): Result<LocationHereApiResult> {
        val coordinateString = "${coordinate.latitude},${coordinate.longitude}"
        val url = SEARCH_LOC
            .replace(Key.COORDINATE, coordinateString)
            .replace(Key.NAME, name)
            .replace(Key.LIMIT, limit.toString())
        return getHttp(url)
    }

    fun reserveLocation(coordinate: Coordinate): Result<LocationHereApiResult> {
        val coordinateString = "${coordinate.latitude},${coordinate.longitude}"
        val url = RESERVE_LOC
            .replace(Key.COORDINATE, coordinateString)

        return getHttp(url)
    }

    fun getRoutes(origin: Coordinate, destination: Coordinate): Result<LocationHereRouteResult> {
        val coordinateOriginString = "${origin.latitude},${origin.longitude}"
        val coordinateDestinationString = "${destination.latitude},${destination.longitude}"
        val url = ROUTES_POLYLINE_LOC
            .replace(Key.COORDINATE_ORIGIN, coordinateOriginString)
            .replace(Key.COORDINATE_DESTINATION, coordinateDestinationString)

        return getHttp(url)
    }

    // endregion

    // region object methods

    companion object {
        const val SEARCH_LOC = "https://discover.search.hereapi.com/v1/discover?at={{coordinate}}&limit={{limit}}&q={{name}}&apiKey=xg8YaxCz3F1ZgYDG1ZW04_6DXQstC6yl1mJCLr0L1o0"
        const val RESERVE_LOC = "https://revgeocode.search.hereapi.com/v1/revgeocode?at={{coordinate}}&lang=en-US&apiKey=xg8YaxCz3F1ZgYDG1ZW04_6DXQstC6yl1mJCLr0L1o0"
        const val ROUTES_POLYLINE_LOC = "https://router.hereapi.com/v8/routes?transportMode=scooter&origin={{coordinate_origin}}&destination={{coordinate_destination}}&return=polyline&apikey=xg8YaxCz3F1ZgYDG1ZW04_6DXQstC6yl1mJCLr0L1o0"
    }

    object Key {
        const val COORDINATE = "{{coordinate}}"
        const val NAME = "{{name}}"

        const val LIMIT = "{{limit}}"
        const val COORDINATE_ORIGIN = "{{coordinate_origin}}"
        const val COORDINATE_DESTINATION = "{{coordinate_destination}}"
    }

    // endregion
}