package br.gov.inpi.domain;

public class DespachoProcesso {

    private Long id;

    private Despacho despacho;

    private Processo processo;

    private String textoComplementar;

    public Despacho getDespacho() {
        return despacho;
    }

    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public String getTextoComplementar() {
        return textoComplementar;
    }

    public void setTextoComplementar(String textoComplementar) {
        this.textoComplementar = textoComplementar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
