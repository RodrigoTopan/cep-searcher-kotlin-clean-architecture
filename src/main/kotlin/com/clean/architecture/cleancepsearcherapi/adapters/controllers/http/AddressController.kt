package com.clean.architecture.cleancepsearcherapi.adapters.controllers.http;


import com.clean.architecture.cleancepsearcherapi.application.usecases.address.CreationAddressUseCase
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.SearchAddressUseCase
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.dto.AddressResponseDTO
import com.clean.architecture.cleancepsearcherapi.application.usecases.address.dto.CreationAddressRequestDTO
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping("/address")
final class AddressController(
    private val creationAddressUseCase: CreationAddressUseCase,
    private val searchAddressUseCase: SearchAddressUseCase
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<AddressResponseDTO>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(searchAddressUseCase.search());
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<AddressResponseDTO> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(searchAddressUseCase.searchById(id));
    }

    @GetMapping("/{cep}/cep")
    fun findByCep(@PathVariable cep: String): ResponseEntity<AddressResponseDTO> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(searchAddressUseCase.searchByCEP(cep));
    }

    @PostMapping
    fun create(@RequestBody creationAddressRequestDTO: CreationAddressRequestDTO): ResponseEntity<String> {
        creationAddressUseCase.run(creationAddressRequestDTO);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Criado endereço com sucesso!");
    }
}
