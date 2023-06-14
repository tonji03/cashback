package it.dennis.Repository;

import it.dennis.Model.Cliente;

import java.sql.Date;
import java.util.List;

public interface ClienteDAO {
    int insert(String nome, String cognome, Date data_registrazione, int percentuale_cashback);
    void setPercentuale(int id,int percentuale);
    Cliente getClienteById(int id);
    void updateCodiceSocieta(int id_cliente, String codice_societa);
    Cliente getClienteByCodiceSocieta(String id);
    List<Cliente> getAllClienti();

}
