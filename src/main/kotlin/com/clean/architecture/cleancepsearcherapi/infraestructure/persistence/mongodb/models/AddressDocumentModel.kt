package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.models

import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Model
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class AddressDocumentModel(
    @Id var id: String? = null,
    val uuid: String,
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
): Model