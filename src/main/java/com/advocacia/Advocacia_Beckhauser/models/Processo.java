package com.advocacia.Advocacia_Beckhauser.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity (name = "processo")
public class Processo extends EntityID {
    @Column (name = "numero_processo")
    private String numero;


    /*
    * Como criar uma relação entre Processo & Advogado?
    * */
        @Column (name = "ataque")
        private Integer ataque;

        @Column (name = "defesa")
        private Integer defesa;
    /*
    * Criando uma classe AtaqueProcesso * DefesaProcesso?
    * */



    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }


    @Override
    public String toString() {
        return "Processo{" +
                "numero='" + numero + '\'' +
                ", ataque=" + ataque +
                ", defesa=" + defesa +
                '}';
    }
}