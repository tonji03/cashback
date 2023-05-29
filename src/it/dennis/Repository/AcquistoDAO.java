package it.dennis.Repository;

import it.dennis.Model.Acquisto;

import java.sql.Date;
import java.util.List;

public interface AcquistoDAO {
    void insert(int id_cliente, double prezzo, Date data_acquisto);
    void insert(double prezzo, Date data_acquisto);
    Acquisto getAcquistoById(int id);
    List<Acquisto> getAllAcquisti();
}
