package com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql

import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepository
import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepositoryJPA
import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.models.AddressModel
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import org.springframework.stereotype.Repository
import java.util.Objects.isNull

@Repository
class SqlAddressRepository(private val addressRepositoryJPA: AddressRepositoryJPA) : AddressRepository {
    override fun findAll(): List<AddressEntity> {
        val addressesModel = addressRepositoryJPA.findAll();
        return addressesModel
            .filterNotNull()
            .map { address -> mapToAddressEntity(address); };
    }

    override fun findByCep(cepRegex: String): AddressEntity? {
        val addressModel = addressRepositoryJPA.findByCep(cepRegex);
        if(isNull(addressModel)) return null;
        return addressModel?.let { mapToAddressEntity(it) };
    }

    override fun findById(id: String): AddressEntity? {
        val addressModel = addressRepositoryJPA.findById(id.toInt()).get();
        if(isNull(addressModel)) return null;
        return mapToAddressEntity(addressModel);
    }

    override fun create(addressEntity: AddressEntity) {
        val (_, cep, street, district, city, state) = addressEntity;
        val addressModel = AddressModel(null, cep, street, district, city, state);
        addressRepositoryJPA.saveAndFlush(addressModel)
    }

    fun mapToAddressEntity(addressModel: AddressModel): AddressEntity {
        val (id, cep, street, district, city, state) = addressModel;
        return AddressEntity(id.toString(), cep, street, district, city, state);
    }

    fun mapToAddressModel(addressEntity: AddressEntity): AddressModel {
        val (id, cep, street, district, city, state) = addressEntity;
        return AddressModel(id.toInt(), cep, street, district, city, state);
    }
}