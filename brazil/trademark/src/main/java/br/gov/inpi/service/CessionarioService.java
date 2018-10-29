package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Cessionario;
import br.gov.inpi.mapper.CessionarioMapper;
import org.apache.ibatis.session.SqlSession;

public class CessionarioService {

    public void inserir(Cessionario cessionario) {

        if (cessionario != null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {
                CessionarioMapper cessionarioMapper = sqlSession.getMapper(CessionarioMapper.class);

                Cessionario c = cessionarioMapper.getCessionario(cessionario);

                if (c == null) {
                    cessionarioMapper.inserir(cessionario);
                } else {
                    cessionario.setId(c.getId());
                    cessionarioMapper.atualizar(cessionario);
                }

                sqlSession.commit();

            } finally {
                sqlSession.close();
            }
        }

    }
}
