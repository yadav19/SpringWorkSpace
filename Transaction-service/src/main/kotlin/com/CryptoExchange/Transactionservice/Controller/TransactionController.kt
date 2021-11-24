package com.CryptoExchange.Transactionservice.Controller

import com.CryptoExchange.Transactionservice.Beans.TradeLimits
import com.CryptoExchange.Transactionservice.Model.Transactions
import com.CryptoExchange.Transactionservice.Repository.TransactionsRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import com.CryptoExchange.Transactionservice.Configurations.Configuration
import org.springframework.beans.factory.annotation.Autowired

@RestController
class TransactionController(private var transactionsRepo: TransactionsRepository) {

    @Autowired
    lateinit var configs: Configuration

    @GetMapping("/transactions")
    fun getTransactions(): ResponseEntity<List<Transactions>>{
        return ResponseEntity.ok(transactionsRepo.findAll())
    }

    @GetMapping("/transaction/{from}/{to}/{quantity}/{rate}")
    fun transaction(
        @PathVariable from: String,
        @PathVariable to: String,
        @PathVariable quantity: Int,
        @PathVariable rate: Float
    ): ResponseEntity<Any>
    {
        println(quantity)
        println(rate)
      if(quantity*rate > configs.tradeUpperLimit || quantity*rate < configs.tradeLowerLimit)
      {

          var ret = object {
              val status: String = "Failed, Cannot be more than 100000.0/- and less than 100.0/-"
              val value = quantity*rate
          }
          return ResponseEntity.ok(ret)
      }
        else
      {
            var tmp: Transactions = Transactions(from = from, to = to, total = quantity*rate,t_id = transactionsRepo.findAll().size)
            transactionsRepo.save(tmp)
            var ret = object {
                val status: String = "Success"
                val value = tmp.total
            }
          return ResponseEntity.ok(ret)
      }
    }
}