package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Processo;
import br.gov.inpi.domain.Sobrestador;
import br.gov.inpi.mapper.SobrestadorMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SobrestadorService {

    public void inserir(Sobrestador sobrestador, Processo processo) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            SobrestadorMapper sobrestadorMapper = sqlSession.getMapper(SobrestadorMapper.class);


            Sobrestador s = sobrestadorMapper.getSobrestador(sobrestador);

            sobrestador.setProcessoRelacionado(processo);

            if (s == null) {
                sobrestadorMapper.inserir(sobrestador);
            } else {
                sobrestador.setId(s.getId());
                sobrestadorMapper.atualizar(sobrestador);
            }

            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }

    public void inserir(List<Sobrestador> sobrestadores, Processo processo) {
        if (sobrestadores != null) {
            for (Sobrestador sobrestador : sobrestadores) {
                inserir(sobrestador, processo);
            }
        }
    }
}
