package com.example.projjavaEE.Services;

import com.example.projjavaEE.modele.Compte;
import com.example.projjavaEE.repository.CompteRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CompteservImpl implements Compteservice{

    private final CompteRepo compterepo;

    @Override
    public Compte creer(Compte Client){
        return  this.compterepo.save(Client);
    }

    @Override
    public List<Compte> lire() {
        return compterepo.findAll();
    }


    @Override
    public Compte modifier(Long id, Compte compte) {
        return null;
    }

    @Override
    public String supprimer(Long id) {
        return null;
    }
}
