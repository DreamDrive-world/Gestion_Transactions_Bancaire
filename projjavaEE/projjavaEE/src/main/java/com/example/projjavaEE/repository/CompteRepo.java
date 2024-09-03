package com.example.projjavaEE.repository;

import com.example.projjavaEE.modele.Client;
import com.example.projjavaEE.modele.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte, Long> {
}
