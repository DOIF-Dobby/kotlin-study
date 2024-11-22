package com.example.demo.exchange.service

import com.example.demo.exchange.domain.UserOrder
import com.example.demo.exchange.domain.UserOrderRepository
import com.example.demo.money.Money
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserOrderService(
  private val userOrderRepository: UserOrderRepository
) {

  @Transactional
  fun createOrder() {
    val exchangeRateValue = 1407.00
    // 2145013.71

    val usd = Money.usd(1524.53)
    UserOrder(
      fromMoney = usd,
      toMoney = usd.exchangeKrw(exchangeRateValue),
    ).let { userOrderRepository.save(it) }

  }

  @Transactional(readOnly = true)
  fun findUserOrder(id: Long): UserOrder {
    return userOrderRepository.findById(id).orElseThrow()
  }
}