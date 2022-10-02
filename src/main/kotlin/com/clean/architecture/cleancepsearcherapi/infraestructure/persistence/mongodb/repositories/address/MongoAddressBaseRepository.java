package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.repositories.address;

import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.models.AddressDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAddressBaseRepository extends MongoRepository<AddressDocumentModel, String> {
    AddressDocumentModel findByCep(String cepRegex);
}
