package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.repositories.address

import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Mapper
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.models.AddressDocumentModel
import org.springframework.stereotype.Repository
import java.util.Objects.isNull


@Repository
class MongoAddressRepositoryImpl(
    private val mongoAddressBaseRepository: MongoAddressBaseRepository,
    private val addressMapper: Mapper<AddressEntity, AddressDocumentModel>
) : AddressRepository {
    override fun findAll(): List<AddressEntity?> {
        return mongoAddressBaseRepository
            .findAll()
            .filterNotNull()
            .map { addressDocument -> addressMapper.toEntity(addressDocument); }
    }

    override fun findByCep(cepRegex: String): AddressEntity? {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): AddressEntity? {
        val addressModel = mongoAddressBaseRepository.findById(id).get();
        if (isNull(addressModel)) return null;
        return addressMapper.toEntity(addressModel);
    }

    override fun create(addressEntity: AddressEntity) {
        mongoAddressBaseRepository.save(addressMapper.toModel(addressEntity));
    }

}