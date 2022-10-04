package com.clean.architecture.cleancepsearcherapi.domain.entities;

import com.clean.architecture.cleancepsearcherapi.domain.Entity
import com.clean.architecture.cleancepsearcherapi.domain.exceptions.InvalidCepFormatException
import com.clean.architecture.cleancepsearcherapi.domain.exceptions.RequiredFieldException
import java.util.*

data class NewAddress(
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
) {
    fun create() = AddressEntity(UUID.randomUUID(), cep, street, district, city, state)
}


data class AddressEntity(
    override val uuid: UUID,
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
) : Entity {
    init {
        if (cep == null || cep == "")
            throw RequiredFieldException("cep")

        if (!cep.matches(Regex("[0-9]{8}")))
            throw InvalidCepFormatException()

        if (street == null || street == "")
            throw RequiredFieldException("street")

        if (district == null || district == "")
            throw RequiredFieldException("district")

        if (city == null || city == "")
            throw RequiredFieldException("city")

        if (state == null || state == "")
            throw RequiredFieldException("state")
    }
}