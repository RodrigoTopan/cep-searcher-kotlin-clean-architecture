package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.repositories.address

import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.models.AddressTableModel
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

@Profile("sql")
interface SqlAddressBaseRepository : JpaRepository<AddressTableModel, Long> {
    fun findByCep(cepRegex: String): Optional<AddressTableModel>
    fun findByUuid(uuid: String): Optional<AddressTableModel>
}