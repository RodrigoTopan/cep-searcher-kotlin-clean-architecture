package com.clean.architecture.cleancepsearcherapi.application.usecases.address

import com.clean.architecture.cleancepsearcherapi.application.usecases.address.dto.AddressResponseDTO

interface SearchAddressUseCase {
    fun search(): List<AddressResponseDTO>
    fun searchByCEP(cep: String): AddressResponseDTO?
    fun searchById(id: String): AddressResponseDTO?
}