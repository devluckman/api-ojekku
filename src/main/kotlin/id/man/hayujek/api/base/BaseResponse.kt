package id.man.hayujek.api.base

/**
 *
 * Created by Lukmanul Hakim on  02/07/22
 * devs.lukman@gmail.com
 */
open class BaseResponse<T>(
    var status: Boolean = true,
    var message: String = "success",
    var data: T? = null
) {
    companion object {
        fun <T>success(data: T?): BaseResponse<T> {
            return BaseResponse(data = data)
        }

        fun <T>failure(message: String): BaseResponse<T> {
            return BaseResponse(status = false, message = message)
        }
    }
}