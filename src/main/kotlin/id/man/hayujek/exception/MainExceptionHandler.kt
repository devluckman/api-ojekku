package id.man.hayujek.exception


import id.man.hayujek.api.base.BaseResponse
import id.man.hayujek.extentions.Empty
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
/**
 *
 * Created by Lukmanul Hakim on  02/07/22
 * devs.lukman@gmail.com
 */

@ControllerAdvice
class MainExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [MainException::class])
    fun handleThrowable(throwable: MainException): ResponseEntity<BaseResponse<Empty>> {
        return ResponseEntity(BaseResponse.failure(throwable.message ?: "Failure"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}