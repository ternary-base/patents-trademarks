package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.ClasseNacional;
import br.gov.inpi.domain.SubClasseNacional;
import br.gov.inpi.mapper.SubClasseNacionalMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SubClasseNacionalService {

    public void inserir(SubClasseNacional subClasseNacional, ClasseNacional classeNacional) {

        if (subClasseNacional != null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {
                SubClasseNacionalMapper subClasseNacionalMapper = sqlSession.getMapper(SubClasseNacionalMapper.class);

                SubClasseNacional s = subClasseNacionalMapper.getSubClasseNacional(subClasseNacional);
                subClasseNacional.setClasseNacional(classeNacional);

                if (s == null) {
                    subClasseNacionalMapper.inserir(subClasseNacional);
                } else {
                    subClasseNacional.setId(s.getId());
                    subClasseNacionalMapper.atualizar(subClasseNacional);
                }

                sqlSession.commit();

            } finally {
                sqlSession.close();
            }
        }

    }

    public void inserir(List<SubClasseNacional> subClasseNacionais, ClasseNacional classeNacional) {
        if (subClasseNacionais != null) {
            for (SubClasseNacional subClasseNacional : subClasseNacionais) {
                inserir(subClasseNacional, classeNacional);
            }
        }
    }
}
