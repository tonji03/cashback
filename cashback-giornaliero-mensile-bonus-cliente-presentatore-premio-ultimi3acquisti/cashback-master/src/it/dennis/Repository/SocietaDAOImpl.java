package it.dennis.Repository;

import it.dennis.Model.Societa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SocietaDAOImpl implements SocietaDAO{
    private Connection connection;
    public SocietaDAOImpl(){
        try{
            connection = ConnessioneDB.getConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void insert(String id, String nome) {
        String query = "INSERT INTO societa values(?,?);";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,id);
            statement.setString(2,nome);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Societa getSocietaByCodice(String codice_societa) {
        String query = "SELECT * from societa where codice_societa=?";
        Societa societa = null;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,codice_societa);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String nome = resultSet.getString("nome");
                societa = new Societa(codice_societa,nome);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return societa;
    }

    @Override
    public Societa getSocietaByNome(String nome) {
        String query = "SELECT * FROM societa WHERE nome=?";
        Societa societa = null;
        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setString(1,nome);
            ResultSet resultSet = st.executeQuery();
            while(resultSet.next()) {
                String codice_societa = resultSet.getString("codice_societa");
                nome = resultSet.getString("nome");
                societa = new Societa(codice_societa,nome);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return societa;
    }

    @Override
    public List<Societa> getAllSocieta() {
        List<Societa> listSocieta = new ArrayList<>();
        String query = "SELECT * FROM societa order by codice_societa";
        try(PreparedStatement st = connection.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Societa societa = new Societa(rs.getString("codice_societa"),rs.getString("nome"));
                listSocieta.add(societa);
            }
            st.close();
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listSocieta;
    }
}
