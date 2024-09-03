package com.example.projjavaEE.repository;

import com.example.projjavaEE.modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository <Client, Long> {
}
