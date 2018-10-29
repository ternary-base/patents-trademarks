package br.gov.inpi.mapper;

import br.gov.inpi.domain.Protocolo;

public interface ProtocoloMapper {

    void inserir(Protocolo protocolo);

    Protocolo getProtocolo(Protocolo protocolo);

    void atualizar(Protocolo protocolo);
}
