package br.gov.inpi.mapper;


import br.gov.inpi.domain.Titular;

public interface TitularMapper {

    void inserir(Titular titular);

    Titular getTitular(Titular titular);

    void atualizar(Titular titular);

}
