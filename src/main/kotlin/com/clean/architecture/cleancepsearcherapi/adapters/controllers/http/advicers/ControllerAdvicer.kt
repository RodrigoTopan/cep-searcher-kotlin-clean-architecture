package com.clean.architecture.cleancepsearcherapi.adapters.controllers.http.advicers

import com.clean.architecture.cleancepsearcherapi.application.usecases.address.exceptions.AddressNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvicer {

    data class JsonResponse(val message: String?)

    @ExceptionHandler(value = [AddressNotFoundException::class])
    fun handleAddressNotFoundException(e: AddressNotFoundException): ResponseEntity<JsonResponse?>? {
        return ResponseEntity(JsonResponse(e.message), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [RuntimeException::class])
    fun handleInternalServerException(e: RuntimeException): ResponseEntity<JsonResponse?>? {
        return ResponseEntity(JsonResponse(e.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [Exception::class])
    fun handleUnexpectedException(e: Exception): ResponseEntity<JsonResponse?>? {
        return ResponseEntity(JsonResponse(e.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}