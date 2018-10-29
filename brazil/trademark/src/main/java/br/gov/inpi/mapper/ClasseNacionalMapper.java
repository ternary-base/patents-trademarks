package br.gov.inpi.mapper;

import br.gov.inpi.domain.ClasseNacional;

public interface ClasseNacionalMapper {

    void inserir(ClasseNacional classeNacional);

    ClasseNacional getClasseNacional(ClasseNacional classeNacional);

    void atualizar(ClasseNacional classeNacional);
}
