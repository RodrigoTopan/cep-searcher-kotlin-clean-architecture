package com.clean.architecture.cleancepsearcherapi.application.usecases.address.dto;

data class CreationAddressRequestDTO(
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
)