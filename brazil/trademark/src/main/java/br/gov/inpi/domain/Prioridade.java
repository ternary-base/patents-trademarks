package br.gov.inpi.domain;

import br.gov.inpi.formatter.DateFormatter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Date;


@XStreamAlias("prioridade")
public class Prioridade implements Dominio {

    @XStreamOmitField
    private Long id;

    @XStreamOmitField
    private Processo processo;

    @XStreamOmitField
    private Date dataFormatada;

    @XStreamAsAttribute
    private String data;

    @XStreamAsAttribute
    private String numero;

    @XStreamAsAttribute
    private String pais;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public Date getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String data) {
        this.dataFormatada = DateFormatter.format(data);
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public void init() {
        if (data != null) {
            setDataFormatada(data);
        }
    }
}
