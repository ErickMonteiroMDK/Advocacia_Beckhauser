package com.advocacia.Advocacia_Beckhauser.models;

import javax.persistence.Entity;

@Entity(name = "cliente")
public class Cliente extends PessoaFisica {
    public Cliente() {
        super();
    }
}