package models;

import enumns.TipoTimeEnum;

import java.util.UUID;

public class Time {

    /* Obrigatorio:
    1 codigo
    1 atributo que categorize/classifique o objeto (conjunto de informações)
     */
private UUID codigo;

private String nome;

private int titulos;

private int torcida;

private int anoDeFundacao;

private int vitorias;

private int derrotas;

private int saldoDeGols;

private TipoTimeEnum nacionalidade;

    public Time(String nome, int titulos, int torcida, int anoDeFundacao, int vitorias, int derrotas, int saldoDeGols, TipoTimeEnum nacionalidade) {
        this.nome = nome;
        this.titulos = titulos;
        this.torcida = torcida;
        this.anoDeFundacao = anoDeFundacao;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.saldoDeGols = saldoDeGols;
        this.nacionalidade = nacionalidade;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTitulos() {
        return titulos;
    }

    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }

    public int getTorcida() {
        return torcida;
    }

    public void setTorcida(int torcida) {
        this.torcida = torcida;
    }

    public int getAnoDeFundacao() {
        return anoDeFundacao;
    }

    public void setAnoDeFundacao(int anoDeFundacao) {
        this.anoDeFundacao = anoDeFundacao;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public TipoTimeEnum getTipotime() {
        return nacionalidade;
    }

    public void setTipotime(TipoTimeEnum nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getSaldoDeGols() {
        return saldoDeGols;
    }

    public void setSaldoDeGols(int saldoDeGols) {
        this.saldoDeGols = saldoDeGols;
    }
}
