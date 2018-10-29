package br.gov.inpi.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("sub-classe-nacional")
public class SubClasseNacional {

    @XStreamOmitField
    private Long id;

    private ClasseNacional classeNacional;

    @XStreamAsAttribute
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClasseNacional getClasseNacional() {
        return classeNacional;
    }

    public void setClasseNacional(ClasseNacional classeNacional) {
        this.classeNacional = classeNacional;
    }
}
