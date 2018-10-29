package br.gov.inpi.mapper;

import br.gov.inpi.domain.ClassesVienna;

public interface ClassesViennaMapper {

    void inserir(ClassesVienna classesVienna);

    ClassesVienna getClassesVienna(ClassesVienna classesVienna);

    void atualizar(ClassesVienna classesVienna);

}
