package com.example.demo.exchange.controller

import com.example.demo.exchange.dto.UserOrderDto
import com.example.demo.exchange.service.UserOrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserOrderController(
  private val userOrderService: UserOrderService
) {

  @PostMapping("/order")
  fun createOrder() {
    userOrderService.createOrder()
  }

  @GetMapping("/order/{id}")
  fun findUserOrder(@PathVariable id: Long): UserOrderDto {
    val userOrder = userOrderService.findUserOrder(id)
    return UserOrderDto.from(userOrder)
  }
}