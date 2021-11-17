package com.CryptoExchange.Conversionservice.Controller

import com.CryptoExchange.Conversionservice.Model.ExchangeRate
import com.CryptoExchange.Conversionservice.Repository.ExchangeRateRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ConversionController (private var exchangeRepo: ExchangeRateRepository) {
    @GetMapping("/exchange/{from}/{to}/")
    fun getCurrencyRatio(
    @PathVariable from: String,
    @PathVariable to: String ): Any {
        val tmp: ExchangeRate = exchangeRepo.findByFromAndTo(from, to)
        return if(tmp != null) object {
            val status: String = "Success"
            val rate: Float = tmp.rate
        }
        else object {
            val status: String = "Failed"
            val rate: Float = 0f
        }
    }

    @PostMapping("/exchange/")
    fun saveExchangeRate(@RequestBody exchangeRate: ExchangeRate): ResponseEntity<String>{
        exchangeRepo.save(exchangeRate);
        return ResponseEntity.ok("Saved");
    }

}