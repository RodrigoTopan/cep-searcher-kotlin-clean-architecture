package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.models

import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Model
import org.springframework.context.annotation.Profile
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Profile("mongodb")
@Document
data class AddressDocumentModel(
    @Id var id: String? = null,
    val uuid: UUID,
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
) : Model