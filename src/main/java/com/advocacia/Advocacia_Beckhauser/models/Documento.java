package com.advocacia.Advocacia_Beckhauser.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.File;



@Entity(name = "documento")
public class Documento extends EntityID {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private File arquivo;



    public Documento() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
}