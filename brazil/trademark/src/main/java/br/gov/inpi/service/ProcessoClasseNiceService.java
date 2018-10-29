package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.ProcessoClasseNice;
import br.gov.inpi.mapper.ProcessoClasseNiceMapper;
import org.apache.ibatis.session.SqlSession;

public class ProcessoClasseNiceService {


    public void inserir(ProcessoClasseNice processoClasseNice) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            ProcessoClasseNiceMapper processoClasseNiceMapper = sqlSession.getMapper(ProcessoClasseNiceMapper.class);


            ProcessoClasseNice pcn = processoClasseNiceMapper.getProcessoClasseNice(processoClasseNice);

            if (pcn == null) {
                processoClasseNiceMapper.inserir(processoClasseNice);
            }

            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }
}
