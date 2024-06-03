package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employe;

public interface EmployeJpaRepository extends JpaRepository<Employe,Integer> {

}
