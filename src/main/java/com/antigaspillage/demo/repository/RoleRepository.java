package com.antigaspillage.demo.repository;

import com.antigaspillage.demo.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.name=:name")
    Role findRoleByName(@Param("name") String name);
}
