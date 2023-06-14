package it.dennis.Model;

public class Societa {
    private String codice_societa;
    private String nome;

    public Societa(String codice_societa, String nome) {
        setCodice_societa(codice_societa);
        setNome(nome);
    }
    public String getCodice_societa() {
        return codice_societa;
    }

    public void setCodice_societa(String codice_societa) {
        this.codice_societa = codice_societa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
