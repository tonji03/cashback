package it.dennis.Model;

import java.sql.Date;

public class Cliente {
    private int id_cliente;
    private String nome;
    private String cognome;
    private Date data_registrazione;
    private int percentuale_cashback;
    private int cap;

    public Cliente(int id, String nome, String cognome, Date data_registrazione) {
        this.id_cliente = id;
        this.nome = nome;
        this.cognome = cognome;
        this.data_registrazione = data_registrazione;
        this.cap = 1000;
    }

    public Cliente(int id_cliente, String nome, String cognome, Date data_registrazione, int percentuale_cashback, int cap) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cognome = cognome;
        this.data_registrazione = data_registrazione;
        this.percentuale_cashback = percentuale_cashback;
        this.cap = cap;
    }

    public int getPercentuale_cashback() {
        return percentuale_cashback;
    }

    public void setPercentuale_cashback(int percentuale_cashback) {
        this.percentuale_cashback = percentuale_cashback;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getData_registrazione() {
        return data_registrazione;
    }

    public void setData_registrazione(Date data_registrazione) {
        this.data_registrazione = data_registrazione;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id_cliente +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_registrazione=" + data_registrazione +
                ", cap=" + cap +
                '}';
    }
}
