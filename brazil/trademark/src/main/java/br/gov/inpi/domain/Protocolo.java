package br.gov.inpi.domain;

import br.gov.inpi.formatter.DateFormatter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Date;

@XStreamAlias(value = "protocolo")
public class Protocolo implements Dominio {

    @XStreamOmitField
    private Long id;

    @XStreamOmitField
    private Despacho despacho;

    @XStreamOmitField
    private Date dataFormatada;

    @XStreamAsAttribute
    private String numero;

    @XStreamAsAttribute
    private String data;

    @XStreamAsAttribute
    private String codigoServico;

    private Requerente requerente;

    private String procurador;

    private Cessionario cessionario;

    public Cessionario getCessionario() {
        return cessionario;
    }

    public void setCessionario(Cessionario cessionario) {
        this.cessionario = cessionario;
    }

    public String getProcurador() {
        return procurador;
    }

    public void setProcurador(String procurador) {
        this.procurador = procurador;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico;
    }

    public Requerente getRequerente() {
        return requerente;
    }

    public void setRequerente(Requerente requerente) {
        this.requerente = requerente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Despacho getDespacho() {
        return despacho;
    }

    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }

    public void setDataFormatada(Date dataFormatada) {
        this.dataFormatada = dataFormatada;
    }

    public Date getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String data) {
        this.dataFormatada = DateFormatter.format(data);
    }

    public void init() {

        if (data != null) {
            setDataFormatada(data);
        }
    }
}
