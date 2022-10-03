package com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl

import com.clean.architecture.cleancepsearcherapi.core.address.usecases.CreationAddressUseCase
import com.clean.architecture.cleancepsearcherapi.core.ports.AddressRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

class CreationAddressUseCaseImpl(private val addressRepository: AddressRepository) : CreationAddressUseCase {
    override fun run(addressEntity: AddressEntity) {
        addressRepository.create(addressEntity);
    }
}