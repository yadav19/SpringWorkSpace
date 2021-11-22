package com.CryptoExchange.eurekaregistryservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class EurekaRegistryServiceApplication

fun main(args: Array<String>) {
	runApplication<EurekaRegistryServiceApplication>(*args)
}
