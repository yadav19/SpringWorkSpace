package com.CryptoExchange.Transactionservice.Model

import java.sql.Time
import java.time.LocalTime
import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Transactions(
    @Id
    @Generated
    var t_id: Int,
    var from: String,
    var to: String,
    var total: Float,
//    var timeStamp: LocalTime
)
