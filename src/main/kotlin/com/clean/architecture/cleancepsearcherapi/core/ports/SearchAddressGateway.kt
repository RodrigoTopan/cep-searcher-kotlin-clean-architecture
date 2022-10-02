package com.clean.architecture.cleancepsearcherapi.core.ports

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

interface SearchAddressGateway {
    fun findByCep(cepRegex: String): AddressEntity?
}