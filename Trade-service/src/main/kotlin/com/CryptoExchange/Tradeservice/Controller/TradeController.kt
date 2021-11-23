package com.CryptoExchange.Tradeservice.Controller

import com.CryptoExchange.Tradeservice.Bean.ConversionResponseBody
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity


@RestController
class TradeController (private var restTemplate: RestTemplate){
    companion object resBody{
        lateinit var status: String
        var rate: Float = 0.0f
    }
    @GetMapping("/home")
    fun nothingComesUp(): String{
        return "Welcome to Crypto Exchange."
    }
    @GetMapping("/trade/{from}/{too}/{quantity}")
    fun getTrading(
        @PathVariable from: String,
        @PathVariable too: String,
        @PathVariable quantity: Int
    ): ResponseEntity<ConversionResponseBody> {
        var uriVariable = mutableMapOf<String,String>("from" to from,"to" to too)
        var x: ResponseEntity<ConversionResponseBody> = restTemplate.getForEntity("http://localhost:11200/exchange/{from}/{to}",uriVariable)
        var resp: ConversionResponseBody? = x.body
        print(resp?.value)
        if(resp?.status == "Success")
        {
            var nv = mutableMapOf<String,String>("from" to from,"to" to too,"quantity" to quantity.toString(), "rate" to resp?.value.toString())
            return restTemplate.getForEntity("http://localhost:11300/transaction/{from}/{to}/{quantity}/{rate}/",nv)
        }
        else{
            return ResponseEntity.ok(ConversionResponseBody(status = "Failure", value = 0f))
        }
    }
}