package it.dennis.Model;

import java.sql.Date;

public class Cashback {
    private int id_cashback;
    private int id_cliente;
    private double totale_cashback;
    private Date data_accredito;

    public Cashback(int id_cashback, int id_cliente, double totale_cashback, Date data_accredito) {
        this.id_cashback = id_cashback;
        this.id_cliente = id_cliente;
        this.totale_cashback = totale_cashback;
        this.data_accredito = data_accredito;
    }

    public Cashback(int id_cliente, double totale_cashback, Date data_accredito) {
        this.id_cliente = id_cliente;
        this.totale_cashback = totale_cashback;
        this.data_accredito = data_accredito;
    }

    public int getId_cashback() {
        return id_cashback;
    }

    public void setId_cashback(int id_cashback) {
        this.id_cashback = id_cashback;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getTotale_cashback() {
        return totale_cashback;
    }

    public void setTotale_cashback(double totale_cashback) {
        this.totale_cashback = totale_cashback;
    }

    public Date getData_accredito() {
        return data_accredito;
    }

    public void setData_accredito(Date data_accredito) {
        this.data_accredito = data_accredito;
    }

    @Override
    public String toString() {
        return "Cashback{" +
                "id_cashback=" + id_cashback +
                ", id_cliente=" + id_cliente +
                ", totale_cashback='" + totale_cashback + '\'' +
                ", data_accredito=" + data_accredito +
                '}';
    }
}
