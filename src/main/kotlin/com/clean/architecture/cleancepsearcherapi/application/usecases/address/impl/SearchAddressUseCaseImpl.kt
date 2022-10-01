package com.clean.architecture.cleancepsearcherapi.application.usecases.address.impl

import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.SearchAddressUseCase
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.dto.AddressResponseDTO
import org.springframework.stereotype.Service
import java.util.Objects.isNull

@Service
class SearchAddressUseCaseImpl(private val addressRepository: AddressRepository) : SearchAddressUseCase {
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
        val addressEntity = addressRepository.findByCep(cep);
        if (isNull(addressEntity)) throw RuntimeException("address not found");

        val (id, cep, street, district, city, state) = checkNotNull(addressEntity);

        return AddressResponseDTO(id, cep, street, district, city, state);
    }

    override fun searchById(id: String): AddressResponseDTO? {
        val addressEntity = addressRepository.findById(id);
        if (isNull(addressEntity)) throw RuntimeException("address not found");

        val (id, cep, street, district, city, state) = checkNotNull(addressEntity);

        return AddressResponseDTO(id, cep, street, district, city, state);
    }
}