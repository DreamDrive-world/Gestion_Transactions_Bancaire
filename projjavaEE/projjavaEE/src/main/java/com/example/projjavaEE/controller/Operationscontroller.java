package com.example.projjavaEE.controller;

import com.example.projjavaEE.Services.Operationservice;

import com.example.projjavaEE.modele.Compte;
import com.example.projjavaEE.modele.Operations;

import com.example.projjavaEE.repository.CompteRepo;
import com.example.projjavaEE.repository.OperationRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Operations")
@AllArgsConstructor
@Slf4j
public class Operationscontroller {

    private final Operationservice operationservice;
    private final OperationRepo operationrepo;
    private final CompteRepo compteRepo;


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/creation")
    @CrossOrigin
    public String creer(@RequestBody Operations operation) throws Exception {
        String opera = "";
        List<Compte> comptes = compteRepo.findAll();
        for (Compte compte : comptes) {
            if (compte.getTestid() == operation.getTestid()) {
                if (compte.getTypecompte().equals(operation.getTypecompte())) {
                    Compte compte1 = compteRepo.findById(compte.getIdcompte()).orElseThrow(() -> new RuntimeException(" Compte non trouvé !"));
                    operation.setCompteop(compte1);
                    Float solde = compte1.getSoldecompte();
                    if (operation.getTypeoperation().equals("Depot")){
                        compte1.setSoldecompte(solde + operation.getMontant());
                        opera =  "Depot";
                    } else if (operation.getTypeoperation().equals("Retrait")) {
                        if (compte1.getSoldecompte() < operation.getMontant()){
                            opera =  "Solde insuffisant pour effectuer le retrait";
                        }else {
                            compte1.setSoldecompte(solde - operation.getMontant());
                            opera =  "Retrait";
                        }
                    }else {
                        for (Compte comptess : comptes) {
                            log.info(" id compte2 {}", comptess.getTestid());
                            log.info(" id compte1 {}", operation.getCompterecep());
                            if (comptess.getTestid() == operation.getCompterecep()) {
                                if (comptess.getTypecompte().equals(operation.getTypecompterecep())) {
                                    log.info(" type de compte {}", comptess.getTypecompte());
                                    Compte compte2 = compteRepo.findById(comptess.getIdcompte()).orElseThrow(() -> new RuntimeException(" Compte non trouvé !"));
                                    Float valeur = operation.getMontant();
                                    Float solde1 = compte1.getSoldecompte();
                                    if (solde1 < valeur){
                                        return "Solde du compte insuffisant";
                                    }
                                    compte1.setSoldecompte(solde1 - valeur);
                                    Float solde2 = compte2.getSoldecompte();
                                    compte2.setSoldecompte(solde2 + valeur);
                                    opera = "Virement";
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        this.operationservice.creer(operation);
        return opera+" effectué";
    }

    @CrossOrigin
    @GetMapping("/lecture")
    public List<Operations> lecture(){
        return operationservice.lire();
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public Operations modification(@PathVariable Long id, @RequestBody Operations operation) {
        return operationservice.modifier(id, operation);
    }

    @CrossOrigin
    @DeleteMapping("/supprimer/{id}")
    public String supprimer( @PathVariable Long id){
        return operationservice.supprimer(id);
    }


    @PostMapping(value = "/verification")
    @CrossOrigin
    public void verification(@RequestBody Operations operation)
    {
        List<Operations> Toperation = this.operationservice.lire();

    }

}
