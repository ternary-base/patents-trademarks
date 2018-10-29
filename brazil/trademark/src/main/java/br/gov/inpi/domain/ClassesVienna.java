package br.gov.inpi.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.List;

@XStreamAlias("classes-vienna")
public class ClassesVienna {

    @XStreamOmitField
    private Long id;

    @XStreamOmitField
    private Processo processo;

    @XStreamAsAttribute
    private String edicao;

    @XStreamImplicit(itemFieldName = "classe-vienna")
    private List<ClasseVienna> classesVienna;


    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public List<ClasseVienna> getClassesVienna() {
        return classesVienna;

    }

    public void setClassesVienna(List<ClasseVienna> classesVienna) {
        this.classesVienna = classesVienna;
    }


    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
