package com.example.projjavaEE.modele;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "Client")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idclient;

    private String Nomclient;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private Integer numerotel;


    @OneToMany(mappedBy = "clientcompte", cascade = CascadeType.ALL)
    @JsonManagedReference("client-compte")
    private List<Compte> Tcompte;

}
