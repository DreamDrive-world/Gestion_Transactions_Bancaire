package com.example.projjavaEE.controller;


import com.example.projjavaEE.Services.Clientservice;
import com.example.projjavaEE.modele.Client;
import com.example.projjavaEE.modele.Compte;
import com.example.projjavaEE.repository.ClientRepo;
import com.example.projjavaEE.repository.CompteRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/Client")
@AllArgsConstructor
@Slf4j
public class Clientcontroller {

    private final Clientservice clientservice;
    private final ClientRepo clientrepo;

    private final CompteRepo compteRepo;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/creation")
    @CrossOrigin
    public void creer(@RequestBody Client client)
    {
        this.clientservice.creerclient(client);
    }

    @CrossOrigin
    @GetMapping("/lecture")
    public List<Client> lecture(){
        return clientservice.lireclient();
    }

    @CrossOrigin
    @GetMapping("/lecturecompte")
    public List<Client> lectureCompte() {
        List<Client> clients = clientrepo.findAll();
        List<Compte> comptes = compteRepo.findAll();
        List<Client> clientsAvecCompte = new ArrayList<>();
        for (Client client : clients) {
            for (Compte compte : comptes) {
                if (client.getIdclient() == compte.getTestid()) {
                    clientsAvecCompte.add(client);
                    break;
                }
            }
        }
        return clientsAvecCompte;
    }


    @PutMapping("/update/{id}")
    public Client modification(@PathVariable Long id, @RequestBody Client client) {
        return clientservice.modifierclient(id, client);
    }

    @CrossOrigin
    @DeleteMapping("/supprimer/{id}")
    public String supprimer( @PathVariable Long id){
        return clientservice.supprimerclient(id);
    }



}
