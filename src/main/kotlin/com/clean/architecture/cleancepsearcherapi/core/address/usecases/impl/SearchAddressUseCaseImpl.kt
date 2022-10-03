package com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl

import com.clean.architecture.cleancepsearcherapi.core.address.exceptions.AddressNotFoundException
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.SearchAddressUseCase
import com.clean.architecture.cleancepsearcherapi.core.ports.AddressRepository
import com.clean.architecture.cleancepsearcherapi.core.ports.SearchAddressGateway
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

class SearchAddressUseCaseImpl(
    private val addressRepository: AddressRepository,
    private val searchAddressGateway: SearchAddressGateway
) : SearchAddressUseCase {
    override fun search(): List<AddressEntity?> {
        return addressRepository.findAll();
    }

    override fun searchByCEP(cep: String): AddressEntity {
        val addressEntity = searchAddressGateway.findByCep(cep) ?: throw AddressNotFoundException("address not found");
        addressRepository.create(addressEntity)
        return addressEntity;
    }

    override fun searchById(uuid: String): AddressEntity {
        return addressRepository.findByUUID(uuid) ?: throw AddressNotFoundException("address not found");
    }
}