package com.antigaspillage.demo.repository;

import com.antigaspillage.demo.data.Role;
import com.antigaspillage.demo.data.Trader;
import com.antigaspillage.demo.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Long> {

    @Query("select t from Trader t where t.user=:user")
    Trader findByUserId(@Param("user")User user);

    @Modifying
    @Transactional
    @Query("update User u set u.role=:role where u.id=:idUser")
    void updateUser(@Param("role") Role role , @Param("idUser")Long id);
}
