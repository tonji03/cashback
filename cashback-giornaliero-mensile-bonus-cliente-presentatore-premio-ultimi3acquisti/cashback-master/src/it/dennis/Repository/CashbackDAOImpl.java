package it.dennis.Repository;

import it.dennis.Model.Acquisto;
import it.dennis.Model.Cashback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CashbackDAOImpl implements CashbackddDAO{
    private Connection connection;
    public CashbackDAOImpl(){
        try{
            connection = ConnessioneDB.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(int id_cliente, double totale_cashback, Date data_accredito) {
        String query = "INSERT INTO cashback (id_cliente,totale_cashback,data_accredito) values (?,?,?)";
        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setInt(1,id_cliente);
            st.setDouble(2,totale_cashback);
            st.setDate(3,data_accredito);
            int rs =st.executeUpdate();

            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Cashback getCashbackById(int id) {
        Cashback cashback = null;
        String query = "SELECT * FROM cashback where id_cashback=?";
        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                cashback = new Cashback(rs.getInt("id_cashback"),rs.getInt("id_cliente"), rs.getDouble("totale_cashback"),rs.getDate("data_credito"));
            }
            st.close();
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cashback;
    }
    @Override
    public Cashback getCashbackSumByIdCliente(int id) {
        Cashback cashback = null;
        String query = "select id_cliente, sum(totale_cashback) as totale, data_accredito from cashback where id_cliente=? group by id_cliente, data_accredito;";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cashback = new Cashback(rs.getInt("id_cliente"), rs.getDouble("totale"), rs.getDate("data_accredito"));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cashback;
    }

    @Override
    public List<Cashback> getAllCashbackSum(){
        List<Cashback> cashbacks = new ArrayList<>();
        String query = "select id_cliente, sum(totale_cashback) as totale, data_accredito from cashback group by id_cliente, data_accredito;";
        try(PreparedStatement st = connection.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Cashback cashback = new Cashback(rs.getInt("id_cliente"), rs.getDouble("totale"),rs.getDate("data_credito"));
                cashbacks.add(cashback);
            }
            st.close();
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cashbacks;
    }
    @Override
    public List<Cashback> getAllCashback() {
        List<Cashback> cashbacks = new ArrayList<>();
        String query = "SELECT * FROM cashback order by id_cliente, data_accredito desc";
        try(PreparedStatement st = connection.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Cashback cashback = new Cashback(rs.getInt("id_cashback"),rs.getInt("id_cliente"), rs.getDouble("totale_cashback"),rs.getDate("data_credito"));
                cashbacks.add(cashback);
            }
            st.close();
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cashbacks;
    }
}
