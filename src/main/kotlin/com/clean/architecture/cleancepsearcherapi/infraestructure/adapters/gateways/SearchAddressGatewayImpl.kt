package com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways

import com.clean.architecture.cleancepsearcherapi.core.ports.SearchAddressGateway
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.domain.entities.NewAddress
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.dto.ViaCepAddressResponseDTO
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.feign.ViaCepClient
import org.springframework.stereotype.Service

@Service
class SearchAddressGatewayImpl(private val viaCepClient: ViaCepClient) : SearchAddressGateway {
    override fun findByCep(cepRegex: String): AddressEntity? {
        val viaCepAddress: ViaCepAddressResponseDTO = viaCepClient.searchAddress(cepRegex);
        val cep = viaCepAddress.cep.replace("-", "")
        return NewAddress(
            cep,
            viaCepAddress.logradouro,
            viaCepAddress.bairro,
            viaCepAddress.localidade,
            viaCepAddress.uf
        ).create();
    }
}