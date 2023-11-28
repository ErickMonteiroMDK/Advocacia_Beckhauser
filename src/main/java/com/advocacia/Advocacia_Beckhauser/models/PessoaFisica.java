package com.advocacia.Advocacia_Beckhauser.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
public class PessoaFisica extends Pessoa {
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "profissao", nullable = false)
    private String profissao;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
