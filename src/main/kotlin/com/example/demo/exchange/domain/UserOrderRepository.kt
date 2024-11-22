package com.example.demo.exchange.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserOrderRepository : JpaRepository<UserOrder, Long> {
}