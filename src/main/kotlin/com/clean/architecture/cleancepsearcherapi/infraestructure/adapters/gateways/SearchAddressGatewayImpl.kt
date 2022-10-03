package com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways

import com.clean.architecture.cleancepsearcherapi.core.ports.SearchAddressGateway
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.dto.ViaCepAddressResponseDTO
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.feign.ViaCepClient
import org.springframework.stereotype.Service
import java.util.*

@Service
class SearchAddressGatewayImpl(private val viaCepClient: ViaCepClient) : SearchAddressGateway {
    override fun findByCep(cepRegex: String): AddressEntity? {
        val viaCepAddress: ViaCepAddressResponseDTO = viaCepClient.searchAddress(cepRegex);
        return AddressEntity(
            UUID.randomUUID().toString(),
            viaCepAddress.cep,
            viaCepAddress.logradouro,
            viaCepAddress.bairro,
            viaCepAddress.localidade,
            viaCepAddress.uf
        )
    }
}