package com.CryptoExchange.Transactionservice.Controller

import com.CryptoExchange.Transactionservice.Model.Transactions
import com.CryptoExchange.Transactionservice.Repository.TransactionsRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalTime

@RestController
class TransactionController(private var transactionsRepo: TransactionsRepository) {

    @GetMapping("/transactions")
    fun getTransactions(): ResponseEntity<List<Transactions>>{
        return ResponseEntity.ok(transactionsRepo.findAll())
    }

    @PostMapping("/Transaction/{from}/{to}/{quantity}/{rate}")
    fun transaction(
        @PathVariable from: String,
        @PathVariable to: String,
        @PathVariable quantity: Int,
        @PathVariable rate: Float
    ): Any
    {
      if(quantity*rate > 100000.0 || quantity*rate < 100.0)
      {
          return object {
              val status: String = "Failed, Cannot be more than 100000.0/- and less than 100.0/-"
              val total: Int = 0
          }
      }
        else
      {
            var tmp: Transactions = Transactions(from = from, to = to, total = quantity*rate, t_id = 0)
            transactionsRepo.save(tmp)
            return object {
                val status: String = "Success"
                val total = quantity*rate
            }
      }
    }
}