package Models.Pessoa;

import java.time.LocalDate;

public class Usuario extends Fisica{

    private String documentOAB;

    public Usuario(String cpf, String rg, String nome, String email, LocalDate dtNasc, String endereco, String profissao, String estadoCivil) {
        super(cpf, rg, nome, email, dtNasc, endereco, profissao, estadoCivil);
    }

    public String getDocumentOAB() {
        return documentOAB;
    }
}
