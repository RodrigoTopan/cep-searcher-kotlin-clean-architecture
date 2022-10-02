package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.repositories.address

import com.clean.architecture.cleancepsearcherapi.core.ports.AddressRepository
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Mapper
import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.models.AddressTableModel
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository
import java.util.Objects.isNull

@Primary
@Repository
internal class SqlAddressRepositoryImpl(
    private val sqlAddressBaseRepository: SqlAddressBaseRepository,
    private val addressMapper: Mapper<AddressEntity, AddressTableModel>
) : AddressRepository {
    override fun findAll(): List<AddressEntity> {
        val addressesModel = sqlAddressBaseRepository.findAll();
        return addressesModel
            .filterNotNull()
            .map { address -> addressMapper.toEntity(address); };
    }

    override fun findByCep(cepRegex: String): AddressEntity? {
        val addressModel = sqlAddressBaseRepository.findByCep(cepRegex).get();
        if (isNull(addressModel)) return null;
        return addressMapper.toEntity(addressModel);
    }

    override fun findByUUID(uuid: String): AddressEntity? {
        val addressModel = sqlAddressBaseRepository.findByUuid(uuid).get();
        if (isNull(addressModel)) return null;
        return addressMapper.toEntity(addressModel);
    }

    override fun create(addressEntity: AddressEntity) {
        sqlAddressBaseRepository.saveAndFlush(addressMapper.toModel(addressEntity))
    }
}