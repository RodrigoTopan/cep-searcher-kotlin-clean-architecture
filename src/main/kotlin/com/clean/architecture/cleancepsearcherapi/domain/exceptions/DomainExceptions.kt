package com.clean.architecture.cleancepsearcherapi.domain.exceptions

class RequiredFieldException(requiredField: String) :
    RuntimeException("$requiredField is required")

class InvalidCepFormatException() :
    RuntimeException("invalid cep")

class InvalidUUIDFormatException() :
    RuntimeException("invalid uuid(universally unique identifier) format")