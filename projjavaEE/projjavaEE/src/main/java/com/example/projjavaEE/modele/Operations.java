package com.example.projjavaEE.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table( name = "Operations")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Operations implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idoperations;

    @Column(unique = false)
    private Float montant;

    private String typeoperation;

    private long testid;

    private String typecompte;

    private long compterecep;

    private String typecompterecep;


    private Date dateop;

    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "idcompte")
    @JsonBackReference("operation-compte")
    private Compte compteop;

    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "idbanquier")
    @JsonBackReference("banquier-operation")
    private Banquier banquier;


}
