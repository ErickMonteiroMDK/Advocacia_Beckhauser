package com.advocacia.Advocacia_Beckhauser.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "usuario_advogado")
public class Advogado extends PessoaFisica{

    @Column(name = "oab", nullable = false)
    private String oab;

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }
}
