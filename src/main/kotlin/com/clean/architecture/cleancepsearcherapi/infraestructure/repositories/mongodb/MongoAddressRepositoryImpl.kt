package com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.mongodb

import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.mongodb.base.MongoAddressBaseRepository
import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.models.AddressDocumentModel
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import java.util.Objects.isNull


@Repository
class MongoAddressRepositoryImpl(
    private val mongoAddressBaseRepository: MongoAddressBaseRepository
) : AddressRepository {
    override fun findAll(): List<AddressEntity?> {
        return mongoAddressBaseRepository
            .findAll()
            .filterNotNull()
            .map { addressDocument -> mapToEntity(addressDocument); };
    }

    override fun findByCep(cepRegex: String): AddressEntity? {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): AddressEntity? {
        val addressModel = mongoAddressBaseRepository.findById(id).get();
        if (isNull(addressModel)) return null;
        return mapToEntity(addressModel);
    }

    override fun create(addressEntity: AddressEntity) {
        mongoAddressBaseRepository.save(mapToModel(addressEntity));
    }

    fun mapToEntity(addressDocumentModel: AddressDocumentModel): AddressEntity {
        val (id, cep, street, district, city, state) = addressDocumentModel;
        return AddressEntity(id, cep, street, district, city, state);
    }

    fun mapToModel(addressEntity: AddressEntity): AddressDocumentModel {
        val (_, cep, street, district, city, state) = addressEntity;
        return AddressDocumentModel(null, cep, street, district, city, state);
    }

}