package com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.mappers

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.Mapper
import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.models.AddressTableModel
import org.springframework.stereotype.Component

@Component
internal class SqlAddressMapperImpl: Mapper<AddressEntity, AddressTableModel> {
    override fun toEntity(model: AddressTableModel): AddressEntity {
        val (id, cep, street, district, city, state) = model;
        return AddressEntity(id.toString(), cep, street, district, city, state);
    }

    override fun toModel(entity: AddressEntity): AddressTableModel {
        val (_, cep, street, district, city, state) = entity;
        return AddressTableModel(null, cep, street, district, city, state);
    }
}