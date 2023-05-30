package it.dennis.Service;

import it.dennis.Model.Cliente;
import it.dennis.Repository.ClienteDAO;
import it.dennis.Repository.ClienteDAOImpl;

import java.sql.Date;
import java.util.List;

public class ClienteServiceImpl implements ClienteService{
    ClienteDAO dao = new ClienteDAOImpl();
    @Override
    public int insert(String nome, String cognome, Date data_registrazione, int percentuale_cashback) {
        return dao.insert(nome, cognome, data_registrazione, percentuale_cashback);
    }

    @Override
    public void setPercentuale(int id, int percentuale) {
        dao.setPercentuale(id, percentuale);
    }

    @Override
    public Cliente getClienteById(int id) {
        return dao.getClienteById(id);
    }

    @Override
    public List<Cliente> getAllClienti() {
        return dao.getAllClienti();
    }
}
