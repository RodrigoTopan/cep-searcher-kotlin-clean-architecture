package com.clean.architecture.cleancepsearcherapi.infraestructure.configuration

import com.clean.architecture.cleancepsearcherapi.core.ports.AddressRepository
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl.CreationAddressUseCaseImpl
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl.SearchAddressUseCaseImpl
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.SearchAddressGatewayImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AddressConfiguration {
    @Autowired
    private val addressRepository: AddressRepository? = null

    @Autowired
    private val searchAddressGateway: SearchAddressGatewayImpl? = null

    @Bean
    fun creationAddressUseCase(): CreationAddressUseCaseImpl {
        return CreationAddressUseCaseImpl(addressRepository!!)
    }

    @Bean
    fun searchAddressUseCase(): SearchAddressUseCaseImpl {
        return SearchAddressUseCaseImpl(addressRepository!!, searchAddressGateway!!)
    }
}