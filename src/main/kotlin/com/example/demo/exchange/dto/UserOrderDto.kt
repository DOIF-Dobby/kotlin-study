package com.example.demo.exchange.dto

import com.example.demo.exchange.domain.UserOrder
import com.example.demo.money.Currency
import java.math.BigDecimal
import java.time.LocalDateTime

class UserOrderDto(
  val id: Long,
  val orderDateTime: LocalDateTime,
  val fromAmount: BigDecimal,
  val fromCurrency: Currency,
  val toAmount: BigDecimal,
  val toCurrency: Currency,
) {

  companion object {
    fun from(entity: UserOrder): UserOrderDto {
      return UserOrderDto(
        id = entity.id!!,
        orderDateTime = entity.orderDate,
        fromAmount = entity.fromMoney.amount,
        fromCurrency = entity.fromMoney.currency,
        toAmount = entity.toMoney.amount,
        toCurrency = entity.toMoney.currency,
      )
    }
  }
}