package com.example.projjavaEE.modele;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "Banquier")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Banquier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idbanquier;

    private String nombanquier;

    @Column(unique = true)
    private Integer numerotel;

    @Column(unique = true)
    private String motdepasse;

    @OneToMany(mappedBy = "banquier", cascade = CascadeType.ALL)
    @JsonManagedReference("banquier-operation")
    private List<Operations> Toperations;


}
