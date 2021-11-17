package com.CryptoExchange.Conversionservice.Repository

import com.CryptoExchange.Conversionservice.Model.ExchangeRate
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeRateRepository: JpaRepository<ExchangeRate, Int> {
    fun findByFromAndTo(from: String, to: String): ExchangeRate
}