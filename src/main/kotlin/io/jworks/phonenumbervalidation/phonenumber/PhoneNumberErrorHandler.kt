package io.jworks.phonenumbervalidation.phonenumber

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import java.util.*


@ControllerAdvice
class PhoneNumberErrorHandler : ResponseEntityExceptionHandler() {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                              headers: HttpHeaders,
                                              status: HttpStatus, request: WebRequest): ResponseEntity<Any> {

        val body = LinkedHashMap<String, Any>()
        body["timestamp"] = LocalDateTime.now()
        body["status"] = status.value()
        body["errors"] = ex.bindingResult.fieldErrors.map { it.defaultMessage }

        return ResponseEntity(body, headers, status)

    }

}