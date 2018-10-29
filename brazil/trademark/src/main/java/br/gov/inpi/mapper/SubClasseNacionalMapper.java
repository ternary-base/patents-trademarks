package br.gov.inpi.mapper;

import br.gov.inpi.domain.SubClasseNacional;

public interface SubClasseNacionalMapper {

    void inserir(SubClasseNacional classeNacional);

    SubClasseNacional getSubClasseNacional(SubClasseNacional subClasseNacional);

    void atualizar(SubClasseNacional subClasseNacional);
}
