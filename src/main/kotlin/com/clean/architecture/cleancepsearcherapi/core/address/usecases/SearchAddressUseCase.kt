package com.clean.architecture.cleancepsearcherapi.core.address.usecases

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

interface SearchAddressUseCase {
    fun search(): List<AddressEntity?>
    fun searchByCEP(cep: String): AddressEntity
    fun searchById(id: String): AddressEntity
}