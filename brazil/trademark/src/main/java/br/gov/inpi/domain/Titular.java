package br.gov.inpi.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias(value = "titular")
public class Titular {


    @XStreamOmitField
    private Long id;

    @XStreamAlias("nome-razao-social")
    @XStreamAsAttribute
    private String razaoSocial;

    @XStreamAlias("pais")
    @XStreamAsAttribute
    private String pais;
    @XStreamAlias("uf")
    @XStreamAsAttribute
    private String uf;

    @XStreamOmitField
    private Processo processo;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
