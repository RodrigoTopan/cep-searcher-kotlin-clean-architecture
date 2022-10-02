package com.clean.architecture.cleancepsearcherapi.core.address.dto;

data class CreationAddressRequestDTO(
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
)