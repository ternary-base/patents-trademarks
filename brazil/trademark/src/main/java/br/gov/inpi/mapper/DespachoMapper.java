package br.gov.inpi.mapper;


import br.gov.inpi.domain.Despacho;

public interface DespachoMapper {

    void inserir(Despacho despacho);

    Despacho getDespacho(Despacho despacho);

    void atualizar(Despacho despacho);
}
