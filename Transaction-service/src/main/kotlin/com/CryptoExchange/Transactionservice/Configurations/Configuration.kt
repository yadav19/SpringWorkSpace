package com.CryptoExchange.Transactionservice.Configurations

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("transaction-service")
class Configuration{
    var tradeUpperLimit: Double = 0.0
    var tradeLowerLimit: Double = 0.0
}