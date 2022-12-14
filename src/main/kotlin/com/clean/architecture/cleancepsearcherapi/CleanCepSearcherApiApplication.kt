package com.clean.architecture.cleancepsearcherapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class CleanCepSearcherApiApplication

fun main(args: Array<String>) {
    runApplication<CleanCepSearcherApiApplication>(*args)
}
