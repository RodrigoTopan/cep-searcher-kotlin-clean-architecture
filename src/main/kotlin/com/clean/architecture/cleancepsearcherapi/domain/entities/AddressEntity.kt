package com.clean.architecture.cleancepsearcherapi.domain.entities;

import com.clean.architecture.cleancepsearcherapi.domain.Entity

data class AddressEntity(
    val id: String? = null,
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
): Entity;