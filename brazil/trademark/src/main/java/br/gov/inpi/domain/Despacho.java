package br.gov.inpi.domain;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias(value = "despacho")
public class Despacho {

    @XStreamAsAttribute
    private String codigo;

    @XStreamAsAttribute
    private String nome;

    @XStreamAlias("texto-complementar")
    private String textoComplementar;

    private Protocolo protocolo;

    @XStreamOmitField
    private Processo processo;

    @XStreamOmitField
    private Long id;

    public String getTextoComplementar() {
        return textoComplementar;
    }

    public void setTextoComplementar(String textoComplementar) {
        this.textoComplementar = textoComplementar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
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
