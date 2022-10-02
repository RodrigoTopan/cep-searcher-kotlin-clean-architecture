package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.mappers

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Mapper
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.models.AddressDocumentModel
import org.springframework.stereotype.Component

@Component
class MongoAddressMapperImpl : Mapper<AddressEntity, AddressDocumentModel> {
    override fun toEntity(model: AddressDocumentModel): AddressEntity {
        val (id, cep, street, district, city, state) = model;
        return AddressEntity(id, cep, street, district, city, state);
    }

    override fun toModel(entity: AddressEntity): AddressDocumentModel {
        val (_, cep, street, district, city, state) = entity;
        return AddressDocumentModel(null, cep, street, district, city, state);
    }
}