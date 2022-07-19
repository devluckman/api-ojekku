package id.man.hayujek.core.extentions

import id.man.hayujek.core.base.BaseResponse
import id.man.hayujek.core.exception.MainException
import id.man.hayujek.location.entity.Coordinate

/**
 *
 * Created by Lukmanul Hakim on  02/07/22
 * devs.lukman@gmail.com
 */

inline fun <reified T> T?.orThrow(
    message: String = "${T::class.simpleName} is null"
): T {
    return this ?: throw MainException(message)
}
inline fun <reified T> T?.toResult(
    message: String = "${T::class.simpleName} is null"
): Result<T> {
    return if (this != null) {
        Result.success(this)
    } else {
        Result.failure(MainException(message))
    }
}


fun <T>Result<T>.toResponses(): BaseResponse<T> {
    return if (this.isFailure) {
        throw MainException(this.exceptionOrNull()?.message ?: "Failure")
    } else {
        BaseResponse.success(this.getOrNull())
    }
}

fun String.coordinateStringToData(): Coordinate {
    val coordinateStrings = split(",")
    val lat = coordinateStrings[0].toDoubleOrNull() ?: 0.0
    val lon = coordinateStrings[1].toDoubleOrNull() ?: 0.0
    return Coordinate(lat, lon)
}

object Empty