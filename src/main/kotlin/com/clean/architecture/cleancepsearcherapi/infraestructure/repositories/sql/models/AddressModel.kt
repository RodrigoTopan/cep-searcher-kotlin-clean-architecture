package com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.models

import javax.persistence.*

@Entity
@Table(name = "address")
data class AddressModel(
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
)