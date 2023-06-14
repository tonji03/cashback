package it.dennis.Model;

import java.sql.Date;

public class Acquisto {
    private int id_acquisto;
    private int id_cliente;
    private double prezzo;
    private Date data_acquisto;

    public Acquisto(int id_acquisto, int id_cliente, double prezzo, Date data_acquisto) {
        this.id_acquisto = id_acquisto;
        this.id_cliente = id_cliente;
        this.prezzo = prezzo;
        this.data_acquisto = data_acquisto;
    }

    public Acquisto(double prezzo, Date data_acquisto) {
        this.prezzo = prezzo;
        this.data_acquisto = data_acquisto;
    }

    public int getId_acquisto() {
        return id_acquisto;
    }

    public void setId_acquisto(int id_acquisto) {
        this.id_acquisto = id_acquisto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Date getData_acquisto() {
        return data_acquisto;
    }

    public void setData_acquisto(Date data_acquisto) {
        this.data_acquisto = data_acquisto;
    }

    @Override
    public String toString() {
        return "Acquisto{" +
                "id_acquisto=" + id_acquisto +
                ", id_cliente=" + id_cliente +
                ", prezzo=" + prezzo +
                ", data_acquisto=" + data_acquisto +
                '}';
    }
}
