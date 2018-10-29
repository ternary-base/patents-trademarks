package br.gov.inpi.mapper;

import br.gov.inpi.domain.Marca;

public interface MarcaMapper {

    void inserir(Marca marca);

    Marca getMarca(Marca marca);

    void atualizar(Marca marca);
}
