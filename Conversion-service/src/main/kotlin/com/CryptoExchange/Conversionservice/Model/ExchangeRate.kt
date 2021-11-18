package com.CryptoExchange.Conversionservice.Model

import javax.annotation.Generated
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ExchangeRate(
    @Id
    @Generated
    var id: Int,
    @Column(name = "fromCUR")
    var from: String,
    @Column(name = "toCUR")
    var to: String,
    var rate: Float
)
