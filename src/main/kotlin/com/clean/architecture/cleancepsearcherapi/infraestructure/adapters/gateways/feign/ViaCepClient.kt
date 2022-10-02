package com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.feign

import com.clean.architecture.cleancepsearcherapi.infraestructure.adapters.gateways.dto.ViaCepAddressResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "ViaCepClient", url = "\${viacep.api.url}")
interface ViaCepClient {

    @GetMapping("/{cep}/json")
    fun searchAddress(@PathVariable("cep") cep: String): ViaCepAddressResponseDTO
}