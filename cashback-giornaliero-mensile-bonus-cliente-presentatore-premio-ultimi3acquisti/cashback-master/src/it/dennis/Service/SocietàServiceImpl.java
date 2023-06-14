package it.dennis.Service;

import it.dennis.Model.Societa;
import it.dennis.Repository.SocietaDAO;
import it.dennis.Repository.SocietaDAOImpl;

import java.util.List;

public class SocietàServiceImpl {
    SocietaDAO dao = new SocietaDAOImpl();

    public void insert(String id, String nome){
        dao.insert(id, nome);
    }
    public Societa getSocietaByCodice(String codice_societa){
        return dao.getSocietaByCodice(codice_societa);
    }
    Societa getSocietaByNome(String nome){
        return dao.getSocietaByNome(nome);
    }
    List<Societa> getAllSocieta(){
        return dao.getAllSocieta();
    }
}
