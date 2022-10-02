package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.mappers

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Mapper
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.models.AddressTableModel
import org.springframework.stereotype.Component

@Component
internal class SqlAddressMapperImpl: Mapper<AddressEntity, AddressTableModel> {
    override fun toEntity(model: AddressTableModel): AddressEntity {
        val (_, uuid, cep, street, district, city, state) = model;
        return AddressEntity(uuid, cep, street, district, city, state);
    }

    override fun toModel(entity: AddressEntity): AddressTableModel {
        val (uuid, cep, street, district, city, state) = entity;
        return AddressTableModel(null, uuid, cep, street, district, city, state);
    }
}