package com.antigaspillage.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antigaspillage.demo.data.Trader;

public interface TraderRepo extends JpaRepository<Trader, Long> {

}
