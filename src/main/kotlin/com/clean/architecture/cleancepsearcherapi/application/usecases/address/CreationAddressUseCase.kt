package com.clean.architecture.cleancepsearcherapi.application.usecases.address

import com.clean.architecture.cleancepsearcherapi.application.usecases.address.dto.CreationAddressRequestDTO

interface CreationAddressUseCase {
    fun run(creationAddressRequestDTO: CreationAddressRequestDTO)
}