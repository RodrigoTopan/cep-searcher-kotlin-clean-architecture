package com.clean.architecture.cleancepsearcherapi.core.address.exceptions

class AddressNotFoundException(message: String? = null) :
    RuntimeException(message)

class CreationAddressException(message: String? = null) :
    RuntimeException(message)