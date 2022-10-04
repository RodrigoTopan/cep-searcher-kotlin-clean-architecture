package com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.input.rest.advicers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvicer {

    data class JsonResponse(val message: String?)

    @ExceptionHandler(value = [RuntimeException::class])
    fun handleInternalServerException(e: RuntimeException): ResponseEntity<JsonResponse> {
        return ResponseEntity(JsonResponse(e.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [Exception::class])
    fun handleUnexpectedException(e: Exception): ResponseEntity<JsonResponse> {
        return ResponseEntity(JsonResponse(e.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}