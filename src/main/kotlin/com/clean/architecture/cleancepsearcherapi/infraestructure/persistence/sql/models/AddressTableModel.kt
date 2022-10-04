package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.sql.models

import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.Model
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "address")
data class AddressTableModel(
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val uuid: UUID,
    val cep: String,
    val street: String,
    val district: String,
    val city: String,
    val state: String
) : Model