package com.clean.architecture.cleancepsearcherapi.core.address.usecases

import com.clean.architecture.cleancepsearcherapi.core.address.dto.CreationAddressRequestDTO

interface CreationAddressUseCase {
    fun run(creationAddressRequestDTO: CreationAddressRequestDTO)
}