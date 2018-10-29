package br.gov.inpi.mapper;


import br.gov.inpi.domain.Requerente;

public interface RequerenteMapper {

    void inserir(Requerente requerente);

    Requerente getRequerente(Requerente requerente);

    void atualizar(Requerente requerente);
}
