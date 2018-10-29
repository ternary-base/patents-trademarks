package br.gov.inpi.mapper;

import br.gov.inpi.domain.Busca;

public interface BuscaMapper {


    void inserir(Busca busca);

    Long countBuscas();
}
