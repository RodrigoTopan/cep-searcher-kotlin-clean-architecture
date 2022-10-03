package com.clean.architecture.cleancepsearcherapi.infraestructure.configuration

import com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl.CreationAddressUseCaseImpl
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl.SearchAddressUseCaseImpl
import com.clean.architecture.cleancepsearcherapi.core.ports.AddressRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.SearchAddressGatewayImpl
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Mapper
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.mappers.SqlAddressMapperImpl
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.models.AddressTableModel
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.repositories.address.SqlAddressBaseRepository
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.repositories.address.SqlAddressRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("sql")
@Configuration
class SqlAddressConfiguration {

    @Autowired
    private val sqlAddressBaseRepository: SqlAddressBaseRepository? = null

    @Autowired
    private val searchAddressGateway: SearchAddressGatewayImpl? = null

    @Bean
    fun addressMapper(): Mapper<AddressEntity, AddressTableModel> {
        return SqlAddressMapperImpl()
    }

    @Bean
    fun addressRepository(): AddressRepository {
        return SqlAddressRepositoryImpl(sqlAddressBaseRepository!!, addressMapper()!!)
    }

    @Bean
    fun creationAddressUseCase(): CreationAddressUseCaseImpl {
        return CreationAddressUseCaseImpl(addressRepository()!!)
    }

    @Bean
    fun searchAddressUseCase(): SearchAddressUseCaseImpl {
        return SearchAddressUseCaseImpl(addressRepository()!!, searchAddressGateway!!)
    }
}