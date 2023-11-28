package com.advocacia.Advocacia_Beckhauser.models;

import javax.persistence.*;

@Entity
public class Processo extends EntityID {
    @Column (name = "numero_processo")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "advogado_defesa_id", referencedColumnName = "id")
    private Advogado defesa;

    @ManyToOne
    @JoinColumn(name = "advogado_ataque_id", referencedColumnName = "id")
    private Advogado ataque;



    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Advogado getDefesa() {
        return defesa;
    }

    public void setDefesa(Advogado defesa) {
        this.defesa = defesa;
    }

    public Advogado getAtaque() {
        return ataque;
    }

    public void setAtaque(Advogado ataque) {
        this.ataque = ataque;
    }


    @Override
    public String toString() {
        return "Processo{" +
                "numero='" + numero + '\'' +
                ", defesa=" + defesa +
                ", ataque=" + ataque +
                '}';
    }
}