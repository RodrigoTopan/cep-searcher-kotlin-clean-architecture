package com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql

import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.AddressRepository
import com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories.SqlAddressBaseRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.models.AddressTableModel
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository
import java.util.Objects.isNull

@Primary
@Repository
class SqlAddressRepositoryImpl(
    private val sqlAddressBaseRepository: SqlAddressBaseRepository
) : AddressRepository {
    override fun findAll(): List<AddressEntity> {
        val addressesModel = sqlAddressBaseRepository.findAll();
        return addressesModel
            .filterNotNull()
            .map { address -> mapToEntity(address); };
    }

    override fun findByCep(cepRegex: String): AddressEntity? {
        val addressModel = sqlAddressBaseRepository.findByCep(cepRegex).get();
        if (isNull(addressModel)) return null;
        return mapToEntity(addressModel);
    }

    override fun findById(id: String): AddressEntity? {
        val addressModel = sqlAddressBaseRepository.findById(id.toLong()).get();
        if (isNull(addressModel)) return null;
        return mapToEntity(addressModel);
    }

    override fun create(addressEntity: AddressEntity) {
        sqlAddressBaseRepository.saveAndFlush(mapToModel(addressEntity))
    }

    fun mapToEntity(addressTableModel: AddressTableModel): AddressEntity {
        val (id, cep, street, district, city, state) = addressTableModel;
        return AddressEntity(id.toString(), cep, street, district, city, state);
    }

    fun mapToModel(addressEntity: AddressEntity): AddressTableModel {
        val (_, cep, street, district, city, state) = addressEntity;
        return AddressTableModel(null, cep, street, district, city, state);
    }
}