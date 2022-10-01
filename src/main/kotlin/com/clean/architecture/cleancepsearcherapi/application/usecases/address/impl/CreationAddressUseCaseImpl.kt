package com.clean.architecture.cleancepsearcherapi.application.usecases.address.impl

import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepository
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.CreationAddressUseCase
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.dto.CreationAddressRequestDTO
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import org.springframework.stereotype.Service

@Service
class CreationAddressUseCaseImpl(private val addressRepository: AddressRepository) : CreationAddressUseCase {
    override fun run(creationAddressRequestDTO: CreationAddressRequestDTO) {
        val (cep, street, district, city, state) = creationAddressRequestDTO;
        val addressEntity = AddressEntity(null, cep, street, district, city, state);
        addressRepository.create(addressEntity);
    }
}