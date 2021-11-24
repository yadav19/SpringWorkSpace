package com.CryptoExchange.Conversionservice.Controller

import com.CryptoExchange.Conversionservice.Model.ExchangeRate
import com.CryptoExchange.Conversionservice.Repository.ExchangeRateRepository
import com.CryptoExchange.Conversionservice.bean.ConversionServiceResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ConversionController (private var exchangeRepo: ExchangeRateRepository) {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(ConversionController::class.java)
    }
    @GetMapping("/exchange/{from}/{to}")
    fun getCurrencyRatio(
    @PathVariable from: String,
    @PathVariable to: String ): ResponseEntity<Any> {
        lateinit var rett: Any
            try {
                val tmp: ExchangeRate = exchangeRepo.findByFromAndTo(from, to)
                print(tmp)
                rett = ConversionServiceResponse(status = "Success", value = tmp.rate)
                logger.info("Fetching data successfully completed")
            } catch(e : Exception) {
                rett = ConversionServiceResponse(status = "Failure", value = 50f)
                logger.error("Some error occured while fetching from the data base")
            } finally {
                print(rett)
            return ResponseEntity.ok(rett)
            }


    }

    @PostMapping("/exchange")
    fun saveExchangeRate(@RequestBody exchangeRate: ExchangeRate): ResponseEntity<String>{
        exchangeRepo.save(exchangeRate);
        logger.info("data saved into database")
        return ResponseEntity.ok("Saved");
    }

}