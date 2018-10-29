package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.ClasseNacional;
import br.gov.inpi.domain.Processo;
import br.gov.inpi.domain.SubClasseNacional;
import br.gov.inpi.mapper.ClasseNacionalMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClasseNacionalService {

    public void inserir(ClasseNacional classeNacional, Processo processo) {

        if (classeNacional != null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {
                ClasseNacionalMapper classeNacionalMapper = sqlSession.getMapper(ClasseNacionalMapper.class);

                classeNacional.setProcesso(processo);

                ClasseNacional cn = classeNacionalMapper.getClasseNacional(classeNacional);

                if (cn == null) {
                    classeNacionalMapper.inserir(classeNacional);
                } else {
                    classeNacional.setId(cn.getId());
                    classeNacionalMapper.atualizar(classeNacional);
                }

                sqlSession.commit();

                cn = classeNacionalMapper.getClasseNacional(classeNacional);

                inserirSubClasseNacional(classeNacional.getSubClassesNacional(), cn);

            } finally {
                sqlSession.close();
            }
        }

    }

    private void inserirSubClasseNacional(List<SubClasseNacional> subClassesNacionais, ClasseNacional classeNacional) {
        SubClasseNacionalService service = new SubClasseNacionalService();
        service.inserir(subClassesNacionais, classeNacional);
    }
}
