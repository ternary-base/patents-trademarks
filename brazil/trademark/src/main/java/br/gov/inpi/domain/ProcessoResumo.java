package br.gov.inpi.domain;

import java.util.Date;

public class ProcessoResumo {

    private String razaoSocial;

    private String nome;

    private String procurador;

    private Date dataDeposito;

    private Date dataConcessao;

    private Date dataVigencia;

    private String codigoClasseNacional;

    private String especificacaoClasseNacional;

    private String natureza;

    private String codigoVienna;

    public String getCodigoVienna() {
        return codigoVienna;
    }

    public void setCodigoVienna(String codigoVienna) {
        this.codigoVienna = codigoVienna;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProcurador() {
        return procurador;
    }

    public void setProcurador(String procurador) {
        this.procurador = procurador;
    }

    public Date getDataDeposito() {
        return dataDeposito;
    }

    public void setDataDeposito(Date dataDeposito) {
        this.dataDeposito = dataDeposito;
    }

    public Date getDataConcessao() {
        return dataConcessao;
    }

    public void setDataConcessao(Date dataConcessao) {
        this.dataConcessao = dataConcessao;
    }

    public Date getDataVigencia() {
        return dataVigencia;
    }

    public void setDataVigencia(Date dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public String getCodigoClasseNacional() {
        return codigoClasseNacional;
    }

    public void setCodigoClasseNacional(String codigoClasseNacional) {
        this.codigoClasseNacional = codigoClasseNacional;
    }

    public String getEspecificacaoClasseNacional() {
        return especificacaoClasseNacional;
    }

    public void setEspecificacaoClasseNacional(String especificacaoClasseNacional) {
        this.especificacaoClasseNacional = especificacaoClasseNacional;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

}
