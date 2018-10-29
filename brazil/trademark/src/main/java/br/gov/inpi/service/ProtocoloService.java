package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Cessionario;
import br.gov.inpi.domain.Despacho;
import br.gov.inpi.domain.Protocolo;
import br.gov.inpi.domain.Requerente;
import br.gov.inpi.mapper.ProtocoloMapper;
import org.apache.ibatis.session.SqlSession;

public class ProtocoloService {

    public void inserir(Protocolo protocolo, Despacho despacho) {

        if (protocolo !=null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {
                ProtocoloMapper protocoloMapper = sqlSession.getMapper(ProtocoloMapper.class);

                protocolo.setDespacho(despacho);

                Protocolo p = protocoloMapper.getProtocolo(protocolo);
                protocolo.init();

                if (p == null) {
                    protocoloMapper.inserir(protocolo);
                } else {
                    protocolo.setId(p.getId());
                    protocoloMapper.atualizar(protocolo);
                }

                sqlSession.commit();

                p = protocoloMapper.getProtocolo(protocolo);

                inserirCessionario(protocolo.getCessionario(), p);
                inserirRequerente(protocolo.getRequerente(), p);

            } finally {
                sqlSession.close();
            }
        }

    }


    private void inserirCessionario(Cessionario cessionario, Protocolo protocolo) {
        if (cessionario != null) {
            CessionarioService service = new CessionarioService();
            cessionario.setProtocolo(protocolo);
            service.inserir(cessionario);
        }
    }

    private void inserirRequerente(Requerente requerente, Protocolo protocolo) {

        if (requerente != null) {
            RequerenteService service = new RequerenteService();
            requerente.setProtocolo(protocolo);
            service.inserir(requerente);
        }
    }
}
