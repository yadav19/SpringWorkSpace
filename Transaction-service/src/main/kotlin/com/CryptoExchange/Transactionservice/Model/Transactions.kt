package com.CryptoExchange.Transactionservice.Model

import java.sql.Time
import java.time.LocalTime
import javax.annotation.Generated
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Transactions(
    @Id
    var t_id: Int,
    @Column(name = "fromCur")
    var from: String,
    @Column(name = "toCur")
    var to: String,
    var total: Float,
//    var timeStamp: LocalTime
)
