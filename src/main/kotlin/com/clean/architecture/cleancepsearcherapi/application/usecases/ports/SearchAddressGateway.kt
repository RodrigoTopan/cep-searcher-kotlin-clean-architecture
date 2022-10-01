package com.clean.architecture.cleancepsearcherapi.application.usecases.ports

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

interface SearchAddressGateway {
    fun findByCep(cepRegex: String): AddressEntity?
}