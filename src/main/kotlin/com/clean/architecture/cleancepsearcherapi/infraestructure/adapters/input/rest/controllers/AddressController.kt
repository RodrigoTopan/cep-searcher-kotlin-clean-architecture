package com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.input.rest.controllers;


import com.clean.architecture.cleancepsearcherapi.core.address.usecases.CreationAddressUseCase
import com.clean.architecture.cleancepsearcherapi.core.address.usecases.SearchAddressUseCase
import com.clean.architecture.cleancepsearcherapi.domain.entities.AddressEntity
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.input.rest.dto.CreationAddressRequestDTO
import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.input.rest.dto.SearchAddressResponseDTO
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Slf4j
@RestController
@RequestMapping("/address")
final class AddressController(
    private val creationAddressUseCase: CreationAddressUseCase,
    private val searchAddressUseCase: SearchAddressUseCase
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<SearchAddressResponseDTO>> {
        val addresses = searchAddressUseCase.search();
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(addresses
                .filterNotNull()
                .map { address -> mapToDTO(address) })
    }

    fun mapToDTO(addressEntity: AddressEntity): SearchAddressResponseDTO {
        val (id, cep, street, district, city, state) = addressEntity;
        return SearchAddressResponseDTO(id, cep, street, district, city, state);
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<SearchAddressResponseDTO> {
        val address = searchAddressUseCase.searchById(id);
        val (newId, cep, street, district, city, state) = address;
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(SearchAddressResponseDTO(newId, cep, street, district, city, state));
    }

    @GetMapping("/{cep}/cep")
    fun findByCep(@PathVariable cep: String): ResponseEntity<SearchAddressResponseDTO> {
        val address = searchAddressUseCase.searchByCEP(cep);
        val (id, cep, street, district, city, state) = address;
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(SearchAddressResponseDTO(id, cep, street, district, city, state));
    }

    @PostMapping
    fun create(@RequestBody creationAddressRequestDTO: CreationAddressRequestDTO): ResponseEntity<String> {
        val (cep, street, district, city, state) = creationAddressRequestDTO;
        val addressEntity = AddressEntity(UUID.randomUUID().toString(), cep, street, district, city, state);
        creationAddressUseCase.run(addressEntity);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Criado endereço com sucesso!");
    }
}
