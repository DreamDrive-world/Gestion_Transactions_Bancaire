package com.example.projjavaEE.controller;

import com.example.projjavaEE.Services.Banquierservice;
import com.example.projjavaEE.modele.Banquier;
import com.example.projjavaEE.repository.BanquierRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Banquier")
@AllArgsConstructor
@Slf4j
public class Banquiercontroller {

    private final Banquierservice banquierservice;
    private final BanquierRepo banquierrepo;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/creation")
    @CrossOrigin
    public void creer(@RequestBody Banquier banquier) {
        this.banquierservice.creer(banquier);
    }

    @CrossOrigin
    @GetMapping("/lecture")
    public List<Banquier> lecture() {
        return banquierservice.lire();
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public Banquier modification(@PathVariable Long id, @RequestBody Banquier banquier) {
        return banquierservice.modifier(id, banquier);
    }

    @CrossOrigin
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        return banquierservice.supprimer(id);
    }


    @PostMapping(value = "/verification")
    @CrossOrigin
    public String verification(@RequestBody Banquier banquier) {
        List<Banquier> TBanquier = banquierrepo.findAll();
        for (Banquier banquiers : TBanquier) {
            if (banquiers.getNombanquier() == banquier.getNombanquier()) {
                if (banquiers.getMotdepasse() == banquier.getMotdepasse()) {
                    return "Informations correctes";
                }
            }
        }
        return "Informations incorrectes";
    }
}
