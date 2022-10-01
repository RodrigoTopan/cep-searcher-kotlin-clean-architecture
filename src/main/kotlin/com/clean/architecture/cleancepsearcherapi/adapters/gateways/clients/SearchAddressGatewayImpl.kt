package com.clean.architecture.cleancepsearcherapi.adapters.gateways.clients

import com.clean.architecture.cleancepsearcherapi.adapters.gateways.clients.dto.ViaCepAddressResponseDTO
import com.clean.architecture.cleancepsearcherapi.adapters.gateways.clients.feign.ViaCepClient
import com.clean.architecture.cleancepsearcherapi.application.usecases.ports.SearchAddressGateway
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import org.springframework.stereotype.Service

@Service
class SearchAddressGatewayImpl(private val viaCepClient: ViaCepClient) : SearchAddressGateway {
    override fun findByCep(cepRegex: String): AddressEntity? {
        val viaCepAddress: ViaCepAddressResponseDTO = viaCepClient.searchAddress(cepRegex);
        return AddressEntity(
            null,
            viaCepAddress.cep,
            viaCepAddress.logradouro,
            viaCepAddress.bairro,
            viaCepAddress.localidade,
            viaCepAddress.uf
        )
    }
}