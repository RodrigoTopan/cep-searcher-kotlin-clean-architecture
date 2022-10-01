package com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql

import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.models.AddressTableModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SqlAddressBaseRepository : JpaRepository<AddressTableModel, Long> {
    fun findByCep(cepRegex: String): Optional<AddressTableModel>
}