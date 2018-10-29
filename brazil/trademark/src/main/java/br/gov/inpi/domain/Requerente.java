package br.gov.inpi.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias(value = "requerente")
public class Requerente {

    @XStreamOmitField
    private Long id;

    @XStreamOmitField
    private Protocolo protocolo;

    @XStreamAsAttribute
    @XStreamAlias("nome-razao-social")
    private String razaoSocial;

    @XStreamAsAttribute
    private String pais;

    @XStreamAsAttribute
    private String uf;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Protocolo getProtocolo() {
        return protocolo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }


}
