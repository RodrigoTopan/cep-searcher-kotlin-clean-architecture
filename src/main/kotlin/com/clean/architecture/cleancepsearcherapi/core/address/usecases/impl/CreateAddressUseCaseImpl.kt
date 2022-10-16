package com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl

import com.clean.architecture.cleancepsearcherapi.core.address.exceptions.CreationAddressException
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.CreateAddressUseCase
import com.clean.architecture.cleancepsearcherapi.core.ports.AddressRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

class CreateAddressUseCaseImpl(private val addressRepository: AddressRepository) : CreateAddressUseCase {
    override fun run(addressEntity: AddressEntity) {
        try {
            addressRepository.create(addressEntity)
        } catch (exception: Exception) {
            throw CreationAddressException("address could not be registered")
        }
    }
}