package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.ClasseVienna;
import br.gov.inpi.domain.ClassesVienna;
import br.gov.inpi.domain.Processo;
import br.gov.inpi.mapper.ClassesViennaMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClassesViennaService {

    public void inserir(ClassesVienna classesVienna, Processo processo) {

        if (classesVienna != null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {
                ClassesViennaMapper classesViennaMapper = sqlSession.getMapper(ClassesViennaMapper.class);

                classesVienna.setProcesso(processo);
                ClassesVienna c = classesViennaMapper.getClassesVienna(classesVienna);

                if (c == null) {
                    classesViennaMapper.inserir(classesVienna);
                } else {
                    classesVienna.setId(c.getId());
                    classesViennaMapper.atualizar(classesVienna);
                }

                sqlSession.commit();

                c = classesViennaMapper.getClassesVienna(classesVienna);

                inserirClasseVienna(classesVienna.getClassesVienna(), c);

            } finally {
                sqlSession.close();
            }
        }

    }

    private void inserirClasseVienna(List<ClasseVienna> classeViennas, ClassesVienna classesVienna) {
        ClasseViennaService service = new ClasseViennaService();
        service.inserir(classeViennas, classesVienna);
    }
}
