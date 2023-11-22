package com.advocacia.Advocacia_Beckhauser.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "agenda")
public class Agenda extends EntityID 
{
    
    @Column(name = "dataOcorrencia", nullable = false)
    private LocalDate dataOcorrencia;

    @Column(name = "responsaveis", nullable = false)
    private Integer responsaveis;

    @Column(name = "numeroProcesso", nullable = false)
    private String numeroProcesso;

    @Column(name = "situacao", nullable = false)
    private String situacao;

    @Column(name = "fase", nullable = false)
    private String fase;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "tipoPrazo", nullable = false)
    private String tipoPrazo;

    @Column(name = "dataInicial", nullable = false)
    private LocalDate dataInicial;
    
    @Column(name = "prazo", nullable = false)
    private Integer prazo;

    @Column(name = "dataFatal", nullable = false)
    private LocalDate dataFatal;
    

    public LocalDate getDataOcorrencia() {
        return this.dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Integer getResponsaveis() {
        return this.responsaveis;
    }

    public void setResponsaveis(Integer responsaveis) {
        this.responsaveis = responsaveis;
    }

    public String getNumeroProcesso() {
        return this.numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getFase() {
        return this.fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipoPrazo() {
        return this.tipoPrazo;
    }

    public void setTipoPrazo(String tipoPrazo) {
        this.tipoPrazo = tipoPrazo;
    }

    public LocalDate getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Integer getPrazo() {
        return this.prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public LocalDate getDataFatal() {
        return this.dataFatal;
    }

    public void setDataFatal(LocalDate dataFatal) {
        this.dataFatal = dataFatal;
    }

}






