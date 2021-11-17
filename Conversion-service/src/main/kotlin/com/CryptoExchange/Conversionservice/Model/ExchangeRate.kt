package com.CryptoExchange.Conversionservice.Model

import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ExchangeRate(
    @Id
    @Generated
    var id: Int,
    var from: String,
    var to: String,
    var rate: Float
)
