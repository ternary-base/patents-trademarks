package br.gov.inpi.domain;

import br.gov.inpi.formatter.DateFormatter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Date;
import java.util.List;

@XStreamAlias(value = "processo")
public class Processo implements Dominio {

    @XStreamOmitField
    private Long id;

    @XStreamOmitField
    private Revista revista;

    @XStreamOmitField
    private Date dataDepositoFormatada;

    @XStreamOmitField
    private Date dataConcessaoFormatada;

    @XStreamOmitField
    private Date dataVigenciaFormatada;

    @XStreamAsAttribute
    private String numero;

    @XStreamAsAttribute
    @XStreamAlias("data-deposito")
    private String dataDeposito;

    @XStreamAsAttribute
    @XStreamAlias("data-concessao")
    private String dataConcessao;

    @XStreamAsAttribute
    @XStreamAlias("data-vigencia")
    private String dataVigencia;

    @XStreamAlias("procurador")
    private String procurador;

    private List<Titular> titulares;

    private List<Despacho> despachos;

    @XStreamAlias("classe-nice")
    private ClasseNice classeNice;

    @XStreamAlias("classes-vienna")
    private ClassesVienna classesVienna;

    private Marca marca;

    private String apostila;

    @XStreamAlias("sobrestadores")
    private List<Sobrestador> sobrestadores;

    @XStreamAlias("prioridade-unionista")
    private List<Prioridade> prioridades;

    @XStreamAlias("classe-nacional")
    private ClasseNacional classeNacional;

    public void init() {

        if (dataDeposito != null) {
            setDataDepositoFormatada(dataDeposito);
        }

        if (dataConcessao != null) {
            setDataConcessaoFormatada(dataConcessao);
        }

        if (dataVigencia != null) {
            setDataVigenciaFormatada(dataVigencia);
        }
    }

    public ClasseNacional getClasseNacional() {
        return classeNacional;
    }

    public void setClasseNacional(ClasseNacional classeNacional) {
        this.classeNacional = classeNacional;
    }

    public List<Prioridade> getPrioridades() {
        return prioridades;
    }

    public void setPrioridades(List<Prioridade> prioridades) {
        this.prioridades = prioridades;
    }

    public List<Sobrestador> getSobrestadores() {
        return sobrestadores;
    }

    public void setSobrestadores(List<Sobrestador> sobrestadores) {
        this.sobrestadores = sobrestadores;
    }

    public String getApostila() {
        return apostila;
    }

    public void setApostila(String apostila) {
        this.apostila = apostila;
    }

    public String getDataDeposito() {
        return dataDeposito;
    }

    public void setDataDeposito(String dataDeposito) {
        this.dataDeposito = dataDeposito;
    }

    public String getDataConcessao() {
        return dataConcessao;
    }

    public void setDataConcessao(String dataConcessao) {
        this.dataConcessao = dataConcessao;
    }

    public String getDataVigencia() {
        return dataVigencia;
    }

    public void setDataVigencia(String dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public ClasseNice getClasseNice() {
        return classeNice;
    }

    public void setClasseNice(ClasseNice classeNice) {
        this.classeNice = classeNice;
    }

    public ClassesVienna getClassesVienna() {
        return classesVienna;
    }

    public void setClassesVienna(ClassesVienna classesVienna) {
        this.classesVienna = classesVienna;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Despacho> getDespachos() {
        return despachos;
    }

    public void setDespachos(List<Despacho> despachos) {
        this.despachos = despachos;
    }

    public List<Titular> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<Titular> titulares) {
        this.titulares = titulares;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getProcurador() {
        return procurador;
    }

    public void setProcurador(String procurador) {
        this.procurador = procurador;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    public Date getDataDepositoFormatada() {
        return dataDepositoFormatada;
    }

    public void setDataDepositoFormatada(String data) {
        this.dataDepositoFormatada = DateFormatter.format(data);
    }

    public void setDataDepositoFormatada(Date dataDepositoFormatada) {
        this.dataDepositoFormatada = dataDepositoFormatada;
    }

    public Date getDataConcessaoFormatada() {
        return dataConcessaoFormatada;
    }

    public void setDataConcessaoFormatada(String data) {
        this.dataConcessaoFormatada = DateFormatter.format(data);
    }

    public void setDataConcessaoFormatada(Date dataConcessaoFormatada) {
        this.dataConcessaoFormatada = dataConcessaoFormatada;
    }

    public Date getDataVigenciaFormatada() {
        return dataVigenciaFormatada;
    }

    public void setDataVigenciaFormatada(String data) {
        this.dataVigenciaFormatada = DateFormatter.format(data);
    }

    public void setDataVigenciaFormatada(Date dataVigenciaFormatada) {
        this.dataVigenciaFormatada = dataVigenciaFormatada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
