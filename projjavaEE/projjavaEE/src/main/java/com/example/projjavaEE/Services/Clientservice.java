package com.example.projjavaEE.Services;

import com.example.projjavaEE.modele.Banquier;
import com.example.projjavaEE.modele.Client;

import java.util.List;

public interface Clientservice {

    Client creerclient(Client client);

    List<Client> lireclient();

    Client modifierclient(Long id, Client client);

    String supprimerclient(Long id);


}
