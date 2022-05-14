package com.antigaspillage.demo.repository;

import com.antigaspillage.demo.data.Cart;
import com.antigaspillage.demo.data.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c where c.trader=:trader")
    List<Cart> listTraderCart(@Param("trader")Trader trader);

    @Modifying
    @Transactional
    @Query("delete from Cart c where c.id = :idCard")
    void deletteById(@Param("idCard") Long id);
}
