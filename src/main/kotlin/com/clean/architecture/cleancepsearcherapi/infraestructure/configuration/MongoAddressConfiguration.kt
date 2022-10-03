package com.clean.architecture.cleancepsearcherapi.infraestructure.configuration

import com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl.CreationAddressUseCaseImpl
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.impl.SearchAddressUseCaseImpl
import com.clean.architecture.cleancepsearcherapi.core.ports.AddressRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.SearchAddressGatewayImpl
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Mapper
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.mappers.MongoAddressMapperImpl
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.models.AddressDocumentModel
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.repositories.address.MongoAddressBaseRepository
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.repositories.address.MongoAddressRepositoryImpl
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.mappers.SqlAddressMapperImpl
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.models.AddressTableModel
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.repositories.address.SqlAddressBaseRepository
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.repositories.address.SqlAddressRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("mongodb")
@Configuration
class MongoAddressConfiguration {

    @Autowired
    private val mongoAddressBaseRepository: MongoAddressBaseRepository? = null

    @Autowired
    private val searchAddressGateway: SearchAddressGatewayImpl? = null

    @Bean
    fun addressMapper(): Mapper<AddressEntity, AddressDocumentModel> {
        return MongoAddressMapperImpl()
    }

    @Bean
    fun addressRepository(): AddressRepository {
        return MongoAddressRepositoryImpl(mongoAddressBaseRepository!!, addressMapper()!!)
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