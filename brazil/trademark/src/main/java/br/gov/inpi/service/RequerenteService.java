package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Requerente;
import br.gov.inpi.mapper.RequerenteMapper;
import org.apache.ibatis.session.SqlSession;

public class RequerenteService {

    public void inserir(Requerente requerente) {

        if (requerente != null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {
                RequerenteMapper requerenteMapper = sqlSession.getMapper(RequerenteMapper.class);

                Requerente r = requerenteMapper.getRequerente(requerente);

                if (r == null) {
                    requerenteMapper.inserir(requerente);
                } else {
                    requerente.setId(r.getId());
                    requerenteMapper.atualizar(requerente);
                }

                sqlSession.commit();

            } finally {
                sqlSession.close();
            }
        }

    }

}
