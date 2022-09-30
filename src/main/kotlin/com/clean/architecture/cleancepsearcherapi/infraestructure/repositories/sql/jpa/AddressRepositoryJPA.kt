package com.clean.architecture.cleancepsearcherapi.adapters.gateways.repositories

import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.models.AddressModel
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepositoryJPA : JpaRepository<AddressModel, Int> {
    fun findByCep(cepRegex: String): AddressModel?
}