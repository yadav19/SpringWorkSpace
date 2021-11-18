package com.CryptoExchange.Tradeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate




@SpringBootApplication
class TradeServiceApplication

fun main(args: Array<String>) {
	runApplication<TradeServiceApplication>(*args)
}

@Configuration
class RestTemplateConfig {

	/**
	 * Build a RestTemplate Bean with the default configuration
	 */
	@Bean
	fun restTemplate():RestTemplate {
		return RestTemplateBuilder().build()
	}
}
