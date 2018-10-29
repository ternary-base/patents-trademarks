package br.gov.inpi.domain;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias(value = "sobrestador")
public class Sobrestador {

    @XStreamOmitField
    private Long id;

    @XStreamOmitField
    private Processo processoRelacionado;

    @XStreamAsAttribute
    private String processo;

    @XStreamAsAttribute
    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Processo getProcessoRelacionado() {
        return processoRelacionado;
    }

    public void setProcessoRelacionado(Processo processoRelacionado) {
        this.processoRelacionado = processoRelacionado;
    }
}
