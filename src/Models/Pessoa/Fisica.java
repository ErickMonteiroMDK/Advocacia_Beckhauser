package Models.Pessoa;

import java.time.LocalDate;

public class Fisica extends Pessoa {
    private String cpf;
    private String rg;
    private String profissao;
    private String estadoCivil;
    private LocalDate dtNasc;




    public Fisica(String cpf, String rg, String nome, String email, LocalDate dtNasc, String endereco, String profissao, String estadoCivil) {
        this.cpf = cpf;
        this.rg = rg;
        super.setNome(nome);
        super.setEmail(email);
        super.setEndereco(endereco);
        this.profissao = profissao;
        this.dtNasc = dtNasc;
        this.estadoCivil = estadoCivil;
    }


    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public LocalDate getDtNasc() {return dtNasc;}

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setDtNasc(LocalDate dtNasc) {this.dtNasc = dtNasc;}
}