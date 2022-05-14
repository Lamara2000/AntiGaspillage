package com.antigaspillage.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antigaspillage.demo.data.Cart;

public interface RepoCart extends JpaRepository<Cart, Long> {

}
