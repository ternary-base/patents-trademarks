package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Processo;
import br.gov.inpi.domain.Titular;
import br.gov.inpi.mapper.TitularMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TitularService {

    public void inserir(Titular titular, Processo processo) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            TitularMapper titularMapper = sqlSession.getMapper(TitularMapper.class);

            titular.setProcesso(processo);
            Titular t = titularMapper.getTitular(titular);

            if (t == null) {
                titularMapper.inserir(titular);
            } else {
                titular.setId(t.getId());
                titularMapper.atualizar(titular);
            }

            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }

    public void inserir(List<Titular> titulares, Processo processo) {
        if (titulares != null) {
            for (Titular titular : titulares) {
                inserir(titular, processo);
            }
        }
    }
}
