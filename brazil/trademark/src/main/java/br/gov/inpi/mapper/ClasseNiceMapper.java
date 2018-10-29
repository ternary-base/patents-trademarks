package br.gov.inpi.mapper;


import br.gov.inpi.domain.ClasseNice;

public interface ClasseNiceMapper {

    void inserir(ClasseNice classeNice);

    ClasseNice getClasseNice(ClasseNice classeNice);

    void atualizar(ClasseNice classeNice);
}
