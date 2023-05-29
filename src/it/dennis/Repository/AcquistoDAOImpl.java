package it.dennis.Repository;

import it.dennis.Model.Acquisto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcquistoDAOImpl implements AcquistoDAO{

    private Connection connection;

    public AcquistoDAOImpl(){
        try{
            connection = ConnessioneDB.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void insert(int id_cliente, double prezzo, Date data_acquisto) {
        String query = "INSERT INTO movacqudd(id_cliente,prezzo,data_acquisto) values (?,?,?)";
        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setInt(1,id_cliente);
            st.setDouble(2,prezzo);
            st.setDate(3,data_acquisto);

            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(double prezzo, Date data_acquisto) {
        String query = "INSERT INTO movacqudd(prezzo, data_acquisto) values(?,?)";
        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setDouble(1,prezzo);
            st.setDate(2,data_acquisto);

            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public Acquisto getAcquistoById(int id) {
        String query ="SELECT * FROM movacqudd where id_acquisto=?";
        Acquisto acquisto = null;
        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setInt(1,id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                int id_acquisto = rs.getInt("id_acquisto");
                int id_cliente = rs.getInt("id_cliente");
                double prezzo = rs.getDouble("prezzo");
                Date data_acquisto = rs.getDate("data_acquisto");

                acquisto = new Acquisto(id_acquisto,id_cliente,prezzo,data_acquisto);
            }
            st.close();
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return acquisto;
    }

    @Override
    public List<Acquisto> getAllAcquisti() {
        List<Acquisto> acquisti = new ArrayList<>();
        String query = "SELECT * FROM movacqudd order by id_cliente";
        try(PreparedStatement st = connection.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Acquisto acquisto = new Acquisto(rs.getInt("id_acquisto"),rs.getInt("id_cliente"), rs.getDouble("prezzo"), rs.getDate("data_acquisto"));
                acquisti.add(acquisto);
            }
            st.close();
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return acquisti;
    }
}
