package com.clean.architecture.cleancepsearcherapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CleanCepSearcherApiApplication

fun main(args: Array<String>) {
	runApplication<CleanCepSearcherApiApplication>(*args)
}
