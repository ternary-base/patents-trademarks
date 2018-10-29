package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.ClasseNacional;
import br.gov.inpi.domain.ClasseNice;
import br.gov.inpi.domain.ClassesVienna;
import br.gov.inpi.domain.Contador;
import br.gov.inpi.domain.Despacho;
import br.gov.inpi.domain.Marca;
import br.gov.inpi.domain.Prioridade;
import br.gov.inpi.domain.Processo;
import br.gov.inpi.domain.ProcessoClasseNice;
import br.gov.inpi.domain.ProcessoProtocolo;
import br.gov.inpi.domain.ProcessoPublicacao;
import br.gov.inpi.domain.ProcessoResumo;
import br.gov.inpi.domain.Revista;
import br.gov.inpi.domain.Sobrestador;
import br.gov.inpi.domain.Titular;
import br.gov.inpi.mapper.ProcessoMapper;
import com.hotraccoon.domain.*;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProcessoService {

    public Contador getNumeroProcesso() {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        ProcessoMapper processoMapper = sqlSession.getMapper(ProcessoMapper.class);

        return new Contador(processoMapper.countProcesso());
    }

    public List<ProcessoResumo> getResumoProcesso(Processo processo) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        ProcessoMapper processoMapper = sqlSession.getMapper(ProcessoMapper.class);

        return processoMapper.getResumoProcesso(processo);
    }

    public List<ProcessoPublicacao> getProcessoPublicacao(Processo processo) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        ProcessoMapper processoMapper = sqlSession.getMapper(ProcessoMapper.class);

        return processoMapper.getPublicacao(processo);
    }

    public List<ProcessoProtocolo> getProcessoProtocolo(Processo processo) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        ProcessoMapper processoMapper = sqlSession.getMapper(ProcessoMapper.class);

        return processoMapper.getProtocolo(processo);
    }

    public void inserir(Processo processo, Revista revista) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            ProcessoMapper processoMapper = sqlSession.getMapper(ProcessoMapper.class);

            processo.setRevista(revista);
            processo.init();

            Processo p = processoMapper.getProcesso(processo);

            if (p == null) {
                processoMapper.inserir(processo);
            } else {
                processo.setId(p.getId());
                processoMapper.atualizar(processo);
            }
            sqlSession.commit();

            p = processoMapper.getProcesso(processo);

            inserirMarca(processo.getMarca(), p);
            inserirTitulares(processo.getTitulares(), p);
            inserirDespachos(processo.getDespachos(), p);
            inserirClasseNice(processo.getClasseNice(), p);
            inserirSobrestador(processo.getSobrestadores(), p);
            inserirPrioridade(processo.getPrioridades(), p);
            inserirClasseNacional(processo.getClasseNacional(), p);
            inserirClassesVienna(processo.getClassesVienna(), p);


        } finally {
            sqlSession.close();
        }

    }

    private void inserirClassesVienna(ClassesVienna classesVienna, Processo processo) {
        ClassesViennaService service = new ClassesViennaService();
        service.inserir(classesVienna, processo);
    }

    private void inserirClasseNacional(ClasseNacional classeNacional, Processo processo) {

        ClasseNacionalService service = new ClasseNacionalService();
        service.inserir(classeNacional, processo);
    }

    private void inserirPrioridade(List<Prioridade> prioridades, Processo processo) {

        PrioridadeService service = new PrioridadeService();
        service.inserir(prioridades, processo);

    }

    private void inserirMarca(Marca marca, Processo processo) {

        MarcaService service = new MarcaService();
        service.inserir(marca, processo);

    }

    private void inserirSobrestador(List<Sobrestador> sobrestadores, Processo processo) {

        SobrestadorService service = new SobrestadorService();
        service.inserir(sobrestadores, processo);
    }

    private void inserirClasseNice(ClasseNice classeNice, Processo processo) {


        if (classeNice != null) {

            ClasseNiceService classeNiceService = new ClasseNiceService();
            classeNiceService.inserir(classeNice);
            classeNice.setId(classeNiceService.getClasseNice(classeNice).getId());

            ProcessoClasseNiceService processoClasseNiceService = new ProcessoClasseNiceService();
            ProcessoClasseNice processoClasseNice = new ProcessoClasseNice();
            processoClasseNice.setProcesso(processo);
            processoClasseNice.setClasseNice(classeNice);
            processoClasseNiceService.inserir(processoClasseNice);
        }

    }

    private void inserirDespachos(List<Despacho> despachos, Processo processo) {

        DespachoService service = new DespachoService();
        service.inserir(despachos, processo);

    }

    private void inserirTitulares(List<Titular> titulares, Processo processo) {

        TitularService service = new TitularService();
        service.inserir(titulares, processo);

    }

    public void inserir(List<Processo> processos, Revista revista) {
        for (Processo processo : processos) {
            inserir(processo, revista);
        }
    }
}
