package com.example.projjavaEE.Services;

import com.example.projjavaEE.modele.Banquier;
import com.example.projjavaEE.modele.Client;
import com.example.projjavaEE.repository.BanquierRepo;
import com.example.projjavaEE.repository.ClientRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BanquierservImp implements Banquierservice{
    private final BanquierRepo banquierrepo;


    @Override
    public Banquier creer(Banquier banquier){
        return  this.banquierrepo.save(banquier);
    }

    @Override
    public List<Banquier> lire() {
        return banquierrepo.findAll();
    }

    @Override
    public Banquier modifier(Long id, Banquier banquier) {
        return null;
    }

    @Override
    public String supprimer(Long id) {
        return null;
    }
}
