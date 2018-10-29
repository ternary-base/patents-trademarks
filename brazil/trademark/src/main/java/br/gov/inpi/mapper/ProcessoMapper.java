package br.gov.inpi.mapper;

import br.gov.inpi.domain.Processo;
import br.gov.inpi.domain.ProcessoProtocolo;
import br.gov.inpi.domain.ProcessoPublicacao;
import br.gov.inpi.domain.ProcessoResumo;

import java.util.List;

public interface ProcessoMapper {

    void inserir(Processo processo);

    Processo getProcesso(Processo processo);

    List<ProcessoResumo> getResumoProcesso(Processo processo);

    void atualizar(Processo processo);

    Long countProcesso();

    List<ProcessoPublicacao> getPublicacao(Processo processo);

    List<ProcessoProtocolo> getProtocolo(Processo processo);
}
