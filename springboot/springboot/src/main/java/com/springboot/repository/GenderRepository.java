package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long>{

	Object findBycount(Long count);

}
