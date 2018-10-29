package br.gov.inpi.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias(value = "classe-vienna")
public class ClasseVienna {

    @XStreamOmitField
    private Long id;
    @XStreamOmitField
    private ClassesVienna classesVienna;
    @XStreamAsAttribute
    private String codigo;

    public ClassesVienna getClassesVienna() {
        return classesVienna;
    }

    public void setClassesVienna(ClassesVienna classesVienna) {
        this.classesVienna = classesVienna;
    }

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


}
