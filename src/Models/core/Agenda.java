package Models.core;

import Models.Pessoa.Usuario;

import java.time.LocalDate;

public class Agenda {

    private LocalDate dtOcorrencia;
    private Usuario responsavel;
    private String nrProcesso;
    private String situacao;
    private String fase;
    private String local;
    private String tipoPrazo;
    private LocalDate dtInicial;
    private String prazoEmDias;
    private LocalDate dtFatal;

    public Agenda(LocalDate dtOcorrencia, Usuario responsavel, String nrProcesso, String situacao, String fase, String local, String tipoPrazo, LocalDate dtInicial, String prazoEmDias, LocalDate dtFatal) {
        this.dtOcorrencia = dtOcorrencia;
        this.responsavel = responsavel;
        this.nrProcesso = nrProcesso;
        this.situacao = situacao;
        this.fase = fase;
        this.local = local;
        this.tipoPrazo = tipoPrazo;
        this.dtInicial = dtInicial;
        this.prazoEmDias = prazoEmDias;
        this.dtFatal = dtFatal;
    }

    public String getNrProcesso() {
        return nrProcesso;
    }

    public LocalDate getDtOcorrencia() {
        return dtOcorrencia;
    }

    public void setDtOcorrencia(LocalDate dtOcorrencia) {
        this.dtOcorrencia = dtOcorrencia;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipoPrazo() {
        return tipoPrazo;
    }

    public void setTipoPrazo(String tipoPrazo) {
        this.tipoPrazo = tipoPrazo;
    }

    public LocalDate getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(LocalDate dtInicial) {
        this.dtInicial = dtInicial;
    }

    public String getPrazoEmDias() {
        return prazoEmDias;
    }

    public void setPrazoEmDias(String prazoEmDias) {
        this.prazoEmDias = prazoEmDias;
    }

    public LocalDate getDtFatal() {
        return dtFatal;
    }

    public void setDtFatal(LocalDate dtFatal) {
        this.dtFatal = dtFatal;
    }
}
