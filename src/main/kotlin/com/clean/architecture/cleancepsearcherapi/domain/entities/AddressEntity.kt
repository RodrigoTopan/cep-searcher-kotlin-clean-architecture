package com.clean.architecture.cleancepsearcherapi.domain.entities;

import com.clean.architecture.cleancepsearcherapi.domain.Entity

data class AddressEntity(
    val uuid: String,
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
) : Entity;