package Models.core;

import Models.Pessoa.Usuario;
import Models.Pessoa.Fisica;

import java.time.LocalDate;

public class Documento {

    private String titulo;
    private Fisica cliente;
    private String tipo;
    private String descricao;
    private LocalDate dtEmissao;
    private Usuario usuarioVinculado;
    private String extensao;

    public Fisica getCliente() {
        return cliente;
    }

    public LocalDate getDtEmissao() {
        return dtEmissao;
    }

    public Usuario getUsuarioVinculado() {
        return usuarioVinculado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }
}
