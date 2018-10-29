package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Busca;
import br.gov.inpi.domain.Contador;
import br.gov.inpi.mapper.BuscaMapper;
import org.apache.ibatis.session.SqlSession;

public class BuscaService {


    public void inserir(Busca busca) {

        if (busca != null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {
                BuscaMapper buscaMapper = sqlSession.getMapper(BuscaMapper.class);

                buscaMapper.inserir(busca);

                sqlSession.commit();

            } finally {
                sqlSession.close();
            }
        }

    }

    public Contador getNumeroBuscas() {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        BuscaMapper buscaMapper = sqlSession.getMapper(BuscaMapper.class);

        return new Contador(buscaMapper.countBuscas());
    }

}
