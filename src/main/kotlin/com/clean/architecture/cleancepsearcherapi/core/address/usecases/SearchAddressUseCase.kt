package com.clean.architecture.cleancepsearcherapi.core.address.usecases

import com.clean.architecture.cleancepsearcherapi.core.address.dto.AddressResponseDTO

interface SearchAddressUseCase {
    fun search(): List<AddressResponseDTO>
    fun searchByCEP(cep: String): AddressResponseDTO?
    fun searchById(id: String): AddressResponseDTO?
}