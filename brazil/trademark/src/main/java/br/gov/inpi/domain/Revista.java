package br.gov.inpi.domain;

import br.gov.inpi.formatter.DateFormatter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Date;
import java.util.List;

@XStreamAlias(value = "revista")
public class Revista implements Dominio {

    @XStreamOmitField
    private Date dataFormatada;

    @XStreamOmitField
    private Long id;


    @XStreamImplicit(itemFieldName = "processo")
    private List<Processo> processo;

    @XStreamAsAttribute
    private Long numero;

    @XStreamAsAttribute
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public List<Processo> getProcesso() {
        return processo;
    }

    public void setProcesso(List<Processo> processo) {
        this.processo = processo;
    }


    public Date getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(Date dataFormatada) {
        this.dataFormatada = dataFormatada;
    }

    public void setDataFormatada(String data) {
        this.dataFormatada = DateFormatter.format(data);
    }

    public void init() {

        if (data != null) {
            setDataFormatada(data);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
