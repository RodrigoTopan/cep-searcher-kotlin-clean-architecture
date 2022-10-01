package com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.mongodb.base;

import com.clean.architecture.cleancepsearcherapi.infraestructure.repositories.sql.models.AddressDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAddressBaseRepository extends MongoRepository<AddressDocumentModel, String> {
    AddressDocumentModel findByCep(String cepRegex);
}
