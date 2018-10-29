package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Marca;
import br.gov.inpi.domain.Processo;
import br.gov.inpi.mapper.MarcaMapper;
import org.apache.ibatis.session.SqlSession;

public class MarcaService {

    public void inserir(Marca marca, Processo processo) {

        if (marca != null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {
                MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);

                Marca m = marcaMapper.getMarca(marca);
                marca.setProcesso(processo);

                if (m == null) {
                    marcaMapper.inserir(marca);
                } else {
                    marca.setId(m.getId());
                    marcaMapper.atualizar(marca);
                }

                sqlSession.commit();

            } finally {
                sqlSession.close();
            }

        }
    }


}
