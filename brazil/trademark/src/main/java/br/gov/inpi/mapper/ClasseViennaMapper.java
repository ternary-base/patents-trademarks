package br.gov.inpi.mapper;


import br.gov.inpi.domain.ClasseVienna;

public interface ClasseViennaMapper {


    void inserir(ClasseVienna classeVienna);

    ClasseVienna getClasseVienna(ClasseVienna classeVienna);

    void atualizar(ClasseVienna classeVienna);
}
