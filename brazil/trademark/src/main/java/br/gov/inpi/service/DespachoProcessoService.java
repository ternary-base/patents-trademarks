package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.DespachoProcesso;
import br.gov.inpi.mapper.DespachoProcessoMapper;
import org.apache.ibatis.session.SqlSession;

public class DespachoProcessoService {

    public void inserir(DespachoProcesso despachoProcesso) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            DespachoProcessoMapper despachoProcessoMapper = sqlSession.getMapper(DespachoProcessoMapper.class);


            DespachoProcesso dp = despachoProcessoMapper.getDespachoProcesso(despachoProcesso);

            if (dp == null) {
                despachoProcessoMapper.inserir(despachoProcesso);
            } else {
                despachoProcesso.setId(dp.getId());
                despachoProcessoMapper.atualizar(despachoProcesso);
            }

            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }

}
