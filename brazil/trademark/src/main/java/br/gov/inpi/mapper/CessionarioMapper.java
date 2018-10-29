package br.gov.inpi.mapper;


import br.gov.inpi.domain.Cessionario;

public interface CessionarioMapper {

    void inserir(Cessionario cessionario);

    Cessionario getCessionario(Cessionario cessionario);

    void atualizar(Cessionario cessionario);
}
