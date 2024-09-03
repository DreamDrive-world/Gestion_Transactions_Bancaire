package com.example.projjavaEE.Services;



import com.example.projjavaEE.modele.Operations;

import java.util.List;

public interface Operationservice {
    Operations creer(Operations operation);

    List<Operations> lire();

    Operations modifier(Long id, Operations operation);

    String supprimer(Long id);

}
