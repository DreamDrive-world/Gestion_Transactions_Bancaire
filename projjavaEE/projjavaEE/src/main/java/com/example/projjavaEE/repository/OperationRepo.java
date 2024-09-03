package com.example.projjavaEE.repository;


import com.example.projjavaEE.modele.Operations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepo extends JpaRepository<Operations, Long> {
}
