package com.antigaspillage.demo.repository;

import com.antigaspillage.demo.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(" select u from User u where u.email = :email")
    User findUserWithName(@Param("email") String username);


}
