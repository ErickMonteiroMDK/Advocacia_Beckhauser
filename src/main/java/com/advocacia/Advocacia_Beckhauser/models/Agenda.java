package com.advocacia.Advocacia_Beckhauser.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agenda extends EntityID 
{
    @Column(name = "dataOcorrencia", nullable = false)
    private LocalDate dataOcorrencia;


    @ManyToOne
    @JoinColumn(name = "advogado_responsavel_id", referencedColumnName = "id")
    private Advogado responsavel;

    @ManyToOne
    @JoinColumn(name = "processo_id", referencedColumnName = "id")
    private Processo numeroProcesso;


    @Column(nullable = false)
    private String situacao;

    @Column(nullable = false)
    private String fase;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private String tipoPrazo;

    @Column(nullable = false)
    private LocalDate dataInicial;
    
    @Column(nullable = false)
    private Integer prazo;

    @Column(nullable = false)
    private LocalDate dataFatal;
    


    public LocalDate getDataOcorrencia() {
        return this.dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }


    public Advogado getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Advogado responsavel) {
        this.responsavel = responsavel;
    }

    public Processo getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(Processo numeroProcesso) {
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


    @Override
    public String toString() {
        return "Agenda{" +
                "dataOcorrencia=" + dataOcorrencia +
                ", responsavel=" + responsavel +
                ", numeroProcesso=" + numeroProcesso +
                ", situacao='" + situacao + '\'' +
                ", fase='" + fase + '\'' +
                ", local='" + local + '\'' +
                ", tipoPrazo='" + tipoPrazo + '\'' +
                ", dataInicial=" + dataInicial +
                ", prazo=" + prazo +
                ", dataFatal=" + dataFatal +
                '}';
    }
}