package com.CryptoExchange.ConfigCloudservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@EnableConfigServer
@SpringBootApplication
class ConfigCloudServiceApplication

fun main(args: Array<String>) {
	runApplication<ConfigCloudServiceApplication>(*args)
}
