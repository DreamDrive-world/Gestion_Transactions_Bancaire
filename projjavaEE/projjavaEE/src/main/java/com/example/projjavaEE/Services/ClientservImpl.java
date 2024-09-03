package com.example.projjavaEE.Services;

import com.example.projjavaEE.modele.Client;
import com.example.projjavaEE.repository.ClientRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ClientservImpl implements Clientservice{

    private final ClientRepo clientrepo;


    @Override
    public Client creerclient(Client Client){
        return  this.clientrepo.save(Client);
    }

    @Override
    public List<Client> lireclient() {
        return clientrepo.findAll();
    }


    @Override
    public Client modifierclient(Long id, Client Client) {
        return null;
    }

    @Override
    public String supprimerclient(Long id) {
        return null;
    }
}
