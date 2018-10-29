package br.gov.inpi.mapper;

import br.gov.inpi.domain.Sobrestador;

public interface SobrestadorMapper {

    void inserir(Sobrestador sobrestador);

    Sobrestador getSobrestador(Sobrestador sobrestador);

    void atualizar(Sobrestador sobrestador);
}
