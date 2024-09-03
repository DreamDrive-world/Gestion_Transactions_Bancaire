package com.example.projjavaEE.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table( name = "Compte")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcompte;

    private String typecompte;

    private Float soldecompte;
    private Date dateouverture;

    private long testid;

    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "idclient")
    @JsonBackReference("client-compte")
    private Client clientcompte;

    @OneToMany(mappedBy = "compteop", cascade = CascadeType.ALL)
    @JsonManagedReference("operation-compte")
    private List<Operations> Tclientop;

}
