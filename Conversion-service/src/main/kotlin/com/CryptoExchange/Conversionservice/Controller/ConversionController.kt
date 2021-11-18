package com.CryptoExchange.Conversionservice.Controller

import com.CryptoExchange.Conversionservice.Model.ExchangeRate
import com.CryptoExchange.Conversionservice.Repository.ExchangeRateRepository
import com.CryptoExchange.Conversionservice.bean.ConversionServiceResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ConversionController (private var exchangeRepo: ExchangeRateRepository) {

    @GetMapping("/exchange/{from}/{to}")
    fun getCurrencyRatio(
    @PathVariable from: String,
    @PathVariable to: String ): ResponseEntity<Any> {
        lateinit var rett: Any
            try {
                val tmp: ExchangeRate = exchangeRepo.findByFromAndTo(from, to)
                print(tmp)
                rett = ConversionServiceResponse(status = "Success", value = tmp.rate)
            } catch(e : Exception) {
                rett = ConversionServiceResponse(status = "Failure", value = 50f)
            } finally {
                print(rett)
            return ResponseEntity.ok(rett)
            }


    }

    @PostMapping("/exchange")
    fun saveExchangeRate(@RequestBody exchangeRate: ExchangeRate): ResponseEntity<String>{
        exchangeRepo.save(exchangeRate);
        return ResponseEntity.ok("Saved");
    }

}