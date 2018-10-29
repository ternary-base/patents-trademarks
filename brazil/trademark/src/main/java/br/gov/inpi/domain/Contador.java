package br.gov.inpi.domain;


public class Contador {

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    private Long numero;

    public Contador(Long numero){
        this.numero = numero;
    }

}
