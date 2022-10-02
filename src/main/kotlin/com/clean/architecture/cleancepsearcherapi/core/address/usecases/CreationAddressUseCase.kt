package com.clean.architecture.cleancepsearcherapi.core.address.usecases

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

interface CreationAddressUseCase {
    fun run(addressEntity: AddressEntity)
}