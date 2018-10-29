package br.gov.inpi.domain;

import java.util.Date;

public class Busca {

    private String termo;

    private Date dataBusca;

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public Date getDataBusca() {
        return dataBusca;
    }

    public void setDataBusca(Date dataBusca) {
        this.dataBusca = dataBusca;
    }

}
