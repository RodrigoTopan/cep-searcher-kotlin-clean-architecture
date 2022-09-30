package com.clean.architecture.cleancepsearcherapi.domain.entities;

data class AddressEntity(
    val id: String = "",
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
)