package com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories

import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity

interface AddressRepository {
    fun findAll(): List<AddressEntity?>
    fun findByCep(cepRegex: String): AddressEntity?
    fun findById(id: String): AddressEntity?
    fun create(addressEntity: AddressEntity)
}