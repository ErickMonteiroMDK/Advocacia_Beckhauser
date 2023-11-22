package com.advocacia.Advocacia_Beckhauser.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.File;

@Entity(name = "modelo")
public class Modelo extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private File arquivo;



    public Modelo() {

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
}