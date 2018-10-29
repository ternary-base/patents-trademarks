package br.gov.inpi.domain;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.List;

@XStreamAlias("classe-nacional")
public class ClasseNacional {

    @XStreamOmitField
    private Long id;

    @XStreamOmitField
    private Processo processo;

    @XStreamAsAttribute
    private String codigo;

    private String especificacao;

    @XStreamAlias("sub-classes-nacional")
    private List<SubClasseNacional> subClassesNacional;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public List<SubClasseNacional> getSubClassesNacional() {
        return subClassesNacional;
    }

    public void setSubClassesNacional(List<SubClasseNacional> subClassesNacional) {
        this.subClassesNacional = subClassesNacional;
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
