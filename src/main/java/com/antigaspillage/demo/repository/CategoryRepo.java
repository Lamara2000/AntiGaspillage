package com.antigaspillage.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antigaspillage.demo.data.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
