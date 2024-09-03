package com.example.projjavaEE.controller;



import com.example.projjavaEE.Services.Clientservice;
import com.example.projjavaEE.Services.Compteservice;
import com.example.projjavaEE.modele.Client;
import com.example.projjavaEE.modele.Compte;
import com.example.projjavaEE.repository.ClientRepo;
import com.example.projjavaEE.repository.CompteRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Compte")
@AllArgsConstructor
@Slf4j
public class Comptecontroller {
    private final Compteservice compteservice;
    private final CompteRepo compterepo;

    private final Clientservice clientservice;

    private final ClientRepo clientRepo;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/creation")
    @CrossOrigin
    public String creer(@RequestBody Compte compte) {
        Client client1 = clientRepo.findById(compte.getTestid()).orElseThrow(() -> new RuntimeException(" Client non trouvé !"));
        compte.setClientcompte(client1);
        List<Compte> Lcompte = compterepo.findAll();
        for (Compte compte1 : Lcompte) {
            if (compte1.getTestid() == compte.getTestid()){
                if (compte1.getTypecompte().equals(compte.getTypecompte())){
                    return "Compte deja existant";
                }
            }
        }
        this.compteservice.creer(compte);
        return "Compte ajouté !";
    }

    @CrossOrigin
    @GetMapping("/lecture")
    public List<Compte> lecture(){

        return compteservice.lire();
    }


}
