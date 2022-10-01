package com.clean.architecture.cleancepsearcherapi.infraestructure.repositories

interface Mapper<Entity, Model> {
    fun toEntity(model: Model): Entity
    fun toModel(entity: Entity): Model
}