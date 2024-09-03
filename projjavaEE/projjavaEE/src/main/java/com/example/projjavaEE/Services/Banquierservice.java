package com.example.projjavaEE.Services;

import com.example.projjavaEE.modele.Banquier;
import com.example.projjavaEE.modele.Client;

import java.util.List;

public interface Banquierservice {

    Banquier creer(Banquier banquier);

    List<Banquier> lire();

    Banquier modifier(Long id, Banquier banquier);

    String supprimer(Long id);

}
