package com.clean.architecture.cleancepsearcherapi.infraestructure.configuration;

import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.SearchAddressGatewayImpl;
import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepository;
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl.CreationAddressUseCaseImpl;
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl.SearchAddressUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfiguration {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SearchAddressGatewayImpl searchAddressGateway;

    @Bean
    public CreationAddressUseCaseImpl creationAddressUseCase() {
        return new CreationAddressUseCaseImpl(addressRepository);
    }

    @Bean
    public SearchAddressUseCaseImpl searchAddressUseCase() {
        return new SearchAddressUseCaseImpl(addressRepository, searchAddressGateway);
    }
}
