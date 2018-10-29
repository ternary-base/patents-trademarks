package br.gov.inpi.domain;

public class ProcessoClasseNice {

    private Long id;

    private Processo processo;

    private ClasseNice classeNice;

    public ClasseNice getClasseNice() {
        return classeNice;
    }

    public void setClasseNice(ClasseNice classeNice) {
        this.classeNice = classeNice;
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
