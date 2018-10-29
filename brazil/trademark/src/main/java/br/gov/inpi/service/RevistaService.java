package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Revista;
import br.gov.inpi.mapper.RevistaMapper;
import org.apache.ibatis.session.SqlSession;

public class RevistaService {


    public void inserir(Revista revista) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        revista.init();

        try {
            RevistaMapper revistaMapper = sqlSession.getMapper(RevistaMapper.class);

            Revista r = revistaMapper.getRevista(revista.getNumero());
            if (r == null) {
                revistaMapper.inserir(revista);
            } else {
                revista.setId(r.getId());
                revistaMapper.atualizar(revista);
            }
            sqlSession.commit();
        } finally {
            sqlSession.flushStatements();
            sqlSession.close();
        }

        inserirProcessos(revista);
    }

    private void inserirProcessos(Revista revista) {

        ProcessoService processoService = new ProcessoService();
        processoService.inserir(revista.getProcesso(), getRevistaPorNumero(revista.getNumero()));

    }

    public Revista getRevistaPorNumero(Long numero) {

        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            RevistaMapper revistaMapper = sqlSession.getMapper(RevistaMapper.class);

            return revistaMapper.getRevista(numero);

        } finally {
            sqlSession.close();
        }
    }
}
