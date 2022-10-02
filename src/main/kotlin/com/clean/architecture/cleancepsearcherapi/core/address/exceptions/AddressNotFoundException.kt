package com.clean.architecture.cleancepsearcherapi.core.address.exceptions

class AddressNotFoundException : RuntimeException {
    constructor(message: String) : super(message)
}