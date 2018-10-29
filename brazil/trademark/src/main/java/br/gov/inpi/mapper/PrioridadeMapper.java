package br.gov.inpi.mapper;

import br.gov.inpi.domain.Prioridade;

public interface PrioridadeMapper {


    void inserir(Prioridade prioridade);

    Prioridade getPrioridade(Prioridade prioridade);

    void atualizar(Prioridade prioridade);

}
