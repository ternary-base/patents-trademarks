package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Despacho;
import br.gov.inpi.domain.DespachoProcesso;
import br.gov.inpi.domain.Processo;
import br.gov.inpi.domain.Protocolo;
import br.gov.inpi.mapper.DespachoMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DespachoService {

    public void inserir(Despacho despacho, Processo processo) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            DespachoMapper despachoMapper = sqlSession.getMapper(DespachoMapper.class);


            Despacho d = despachoMapper.getDespacho(despacho);

            despacho.setProcesso(processo);

            if (d == null) {
                despachoMapper.inserir(despacho);
            } else {
                despachoMapper.atualizar(despacho);
            }
            sqlSession.commit();


            d = despachoMapper.getDespacho(despacho);
            DespachoProcesso despachoProcesso = new DespachoProcesso();
            despachoProcesso.setProcesso(processo);
            despachoProcesso.setDespacho(d);
            despachoProcesso.setTextoComplementar(despacho.getTextoComplementar());

            inserirDespachoProcesso(despachoProcesso);

            inserirProtocolo(despacho.getProtocolo(), d);

        } finally {
            sqlSession.close();
        }

    }

    private void inserirDespachoProcesso(DespachoProcesso despachoProcesso) {

        DespachoProcessoService despachoProcessoService = new DespachoProcessoService();
        despachoProcessoService.inserir(despachoProcesso);
    }

    public void inserir(List<Despacho> despachos, Processo processo) {
        if (despachos != null) {
            for (Despacho despacho : despachos) {
                inserir(despacho, processo);
            }
        }
    }

    private void inserirProtocolo(Protocolo protocolo, Despacho despacho) {
        ProtocoloService service = new ProtocoloService();
        service.inserir(protocolo, despacho);
    }
}
