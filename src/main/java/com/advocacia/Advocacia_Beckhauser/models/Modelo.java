package com.advocacia.Advocacia_Beckhauser.models;

import javax.persistence.*;
import java.io.File;
import java.util.Arrays;

@Entity()
public class Modelo extends EntityID {
    @Column(nullable = false)
    private String nome;

    @Lob
    @Column(nullable = false)
    private byte[] dados;

    @ManyToOne
    @JoinColumn(name = "processo_id", referencedColumnName = "id")
    private Processo processo;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        this.dados = dados;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }


    @Override
    public String toString() {
        return "Modelo{" +
                "nome='" + nome + '\'' +
                ", dados=" + Arrays.toString(dados) +
                '}';
    }
}