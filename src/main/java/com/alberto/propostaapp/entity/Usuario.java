package com.alberto.propostaapp.entity;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telfone;
    private Double renda;
    @OneToOne(mappedBy = "usuario")
    private Proposta proposta;
}
