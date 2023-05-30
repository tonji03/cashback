package it.dennis.Repository;

import it.dennis.Model.Cashback;
import it.dennis.Model.Cliente;

import java.sql.Date;
import java.util.List;

public interface CashbackddDAO {
    void insert(int id_cliente, double totale_cashback, Date data_accredito);
    Cashback getCashbackById(int id);
    List<Cashback> getAllCashback();
}
