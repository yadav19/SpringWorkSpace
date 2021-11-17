package com.CryptoExchange.Transactionservice.Repository

import com.CryptoExchange.Transactionservice.Model.Transactions
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionsRepository: JpaRepository<Transactions, Int> {
}