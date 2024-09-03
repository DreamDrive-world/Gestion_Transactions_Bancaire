package com.example.projjavaEE.repository;

import com.example.projjavaEE.modele.Banquier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanquierRepo extends JpaRepository<Banquier, Long> {
}
