package com.clean.architecture.cleancepsearcherapi.application.usecases.address.exceptions

class AddressNotFoundException : RuntimeException {
    constructor(message: String) : super(message)
}