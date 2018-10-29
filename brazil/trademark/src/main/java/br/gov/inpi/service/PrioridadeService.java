package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Prioridade;
import br.gov.inpi.domain.Processo;
import br.gov.inpi.mapper.PrioridadeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PrioridadeService {

    public void inserir(Prioridade prioridade, Processo processo) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            PrioridadeMapper prioridadeMapper = sqlSession.getMapper(PrioridadeMapper.class);

            prioridade.setProcesso(processo);
            prioridade.init();

            Prioridade p = prioridadeMapper.getPrioridade(prioridade);


            if (p == null) {
                prioridadeMapper.inserir(prioridade);
            } else {
                prioridade.setId(p.getId());
                prioridadeMapper.atualizar(prioridade);
            }

            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }

    public void inserir(List<Prioridade> prioridades, Processo processo) {
        if (prioridades != null) {
            for (Prioridade prioridade : prioridades) {
                inserir(prioridade, processo);
            }
        }
    }
}
