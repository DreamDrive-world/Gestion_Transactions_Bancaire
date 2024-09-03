package com.example.projjavaEE.Services;

import com.example.projjavaEE.modele.Compte;

import java.util.List;

public interface Compteservice {
    Compte creer(Compte compte);

    List<Compte> lire();

    Compte modifier(Long id, Compte compte);

    String supprimer(Long id);

}
