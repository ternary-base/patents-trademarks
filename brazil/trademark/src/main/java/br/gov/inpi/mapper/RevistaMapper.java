package br.gov.inpi.mapper;


import br.gov.inpi.domain.Revista;

public interface RevistaMapper {

    void inserir(Revista revista);

    Revista getRevista(Long numero);

    void atualizar(Revista revista);
}
