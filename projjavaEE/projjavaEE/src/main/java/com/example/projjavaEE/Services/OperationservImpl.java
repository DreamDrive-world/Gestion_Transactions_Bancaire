package com.example.projjavaEE.Services;


import com.example.projjavaEE.modele.Operations;
import com.example.projjavaEE.repository.OperationRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OperationservImpl implements Operationservice {

    private final OperationRepo operationrepo;

    @Override
    public Operations creer(Operations operation){
        return  this.operationrepo.save(operation);
    }

    @Override
    public List<Operations> lire() {
        return operationrepo.findAll();
    }


    @Override
    public Operations modifier(Long id, Operations operation) {
        return null;
    }

    @Override
    public String supprimer(Long id) {
        return null;
    }
}
