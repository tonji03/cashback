package it.dennis.Service;

import it.dennis.Model.Cliente;

import java.sql.Date;
import java.util.List;

public interface ClienteService {
    int insert(String nome, String cognome, Date data_registrazione, int percentuale_cashback);
    void setPercentuale(int id,int percentuale);
    void updateCodiceSocieta(int id, String codice_societa);
    Cliente getClienteById(int id);
    List<Cliente> getAllClienti();
}
