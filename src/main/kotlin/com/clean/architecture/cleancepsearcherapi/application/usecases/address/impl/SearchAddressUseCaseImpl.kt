package com.clean.architecture.cleancepsearcherapi.application.usecases.address.impl

import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepository
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.SearchAddressUseCase
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.dto.AddressResponseDTO
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.exceptions.AddressNotFoundException
import com.clean.architecture.cleancepsearcherapi.application.usecases.ports.SearchAddressGateway
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import org.springframework.stereotype.Service

@Service
class SearchAddressUseCaseImpl(
    private val addressRepository: AddressRepository,
    private val searchAddressGateway: SearchAddressGateway
) : SearchAddressUseCase {
    override fun search(): List<AddressResponseDTO> {
        val addresses = addressRepository.findAll();
        return addresses
            .filterNotNull()
            .map { address -> mapToDTO(address); };
    }

    fun mapToDTO(addressEntity: AddressEntity): AddressResponseDTO {
        val (id, cep, street, district, city, state) = addressEntity;
        return AddressResponseDTO(id, cep, street, district, city, state);
    }

    override fun searchByCEP(cep: String): AddressResponseDTO? {
        val addressEntity = searchAddressGateway.findByCep(cep) ?: throw AddressNotFoundException("address not found");
        addressRepository.create(addressEntity)
        val (id, cep, street, district, city, state) = addressEntity;
        return AddressResponseDTO(id, cep, street, district, city, state);
    }

    override fun searchById(id: String): AddressResponseDTO? {
        val addressEntity = addressRepository.findById(id) ?: throw AddressNotFoundException("address not found");
        val (id, cep, street, district, city, state) = addressEntity;
        return AddressResponseDTO(id, cep, street, district, city, state);
    }
}