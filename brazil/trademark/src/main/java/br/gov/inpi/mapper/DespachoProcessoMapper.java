package br.gov.inpi.mapper;


import br.gov.inpi.domain.DespachoProcesso;

public interface DespachoProcessoMapper {

    void inserir(DespachoProcesso despacho);

    DespachoProcesso getDespachoProcesso(DespachoProcesso despacho);

    void atualizar(DespachoProcesso despacho);
}
