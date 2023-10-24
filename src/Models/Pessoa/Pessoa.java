package Models.Pessoa;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String email;
    private LocalDate dtNasc;
    private String endereco;



    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public String getEndereco() {
        return endereco;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}