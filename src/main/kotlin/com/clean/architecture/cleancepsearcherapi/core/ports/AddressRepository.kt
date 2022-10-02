package com.clean.architecture.cleancepsearcherapi.core.ports

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

interface AddressRepository {
    fun findAll(): List<AddressEntity?>
    fun findByCep(cepRegex: String): AddressEntity?
    fun findByUUID(uuid: String): AddressEntity?
    fun create(addressEntity: AddressEntity)
}