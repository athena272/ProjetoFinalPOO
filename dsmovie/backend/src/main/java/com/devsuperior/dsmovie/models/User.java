package com.devsuperior.dsmovie.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_user") // Atribuindo o nomea tabela
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Atribuindo id como chave primária
    private Long id;
    private String email;

    public User(){}

    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
