package it.dennis.Repository;

import it.dennis.Model.Societa;

import java.util.List;

public interface SocietaDAO {
    public void insert(String id, String nome);
    Societa getSocietaByCodice(String codice_societa);
    Societa getSocietaByNome(String nome);
    List<Societa> getAllSocieta();
}
