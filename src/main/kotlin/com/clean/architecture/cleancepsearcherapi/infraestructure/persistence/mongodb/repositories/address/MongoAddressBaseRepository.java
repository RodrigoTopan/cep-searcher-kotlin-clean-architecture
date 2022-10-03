package com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.repositories.address;

import com.clean.architecture.cleancepsearcherapi.infraestructure.persistence.mongodb.models.AddressDocumentModel;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Profile("mongodb")
public interface MongoAddressBaseRepository extends MongoRepository<AddressDocumentModel, String> {
    AddressDocumentModel findByCep(String cepRegex);

    AddressDocumentModel findByUuid(String uuid);
}
