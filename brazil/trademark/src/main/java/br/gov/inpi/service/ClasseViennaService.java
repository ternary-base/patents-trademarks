package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.ClasseVienna;
import br.gov.inpi.domain.ClassesVienna;
import br.gov.inpi.mapper.ClasseViennaMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClasseViennaService {

    public void inserir(ClasseVienna classeVienna, ClassesVienna classesVienna) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            ClasseViennaMapper classeViennaMapper = sqlSession.getMapper(ClasseViennaMapper.class);

            classeVienna.setClassesVienna(classesVienna);
            ClasseVienna c = classeViennaMapper.getClasseVienna(classeVienna);

            if (c == null) {
                classeViennaMapper.inserir(classeVienna);
            } else {
                classeVienna.setId(c.getId());
                classeViennaMapper.atualizar(classeVienna);
            }

            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }

    public void inserir(List<ClasseVienna> classeViennas, ClassesVienna classesVienna) {
        if (classeViennas != null) {
            for (ClasseVienna classeVienna : classeViennas) {
                inserir(classeVienna, classesVienna);
            }
        }
    }
}
