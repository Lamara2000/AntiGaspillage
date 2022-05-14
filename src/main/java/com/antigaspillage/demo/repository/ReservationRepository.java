package com.antigaspillage.demo.repository;

import com.antigaspillage.demo.data.Reservation;
import com.antigaspillage.demo.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(" select r from Reservation r where r.user = :user")
    List<Reservation> findUserWithUser(@Param("user") User user);

    @Modifying
    @Transactional
    @Query("delete from Reservation r where r.id = :idRservation")
    void deletteById(@Param("idRservation") Long id);

}
