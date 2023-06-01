package it.dennis.Repository;

import it.dennis.Model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO{
    private Connection connection;

    public ClienteDAOImpl(){
        try{
            connection = ConnessioneDB.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int insert(String nome, String cognome, Date data_registrazione, int percentuale_cashback) {
        String query = "INSERT INTO cliente(nome,cognome,data_registrazione,percentuale_cashback) values(?,?,?,?)";
        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setString(1,nome);
            st.setString(2,cognome);
            st.setDate(3,data_registrazione);
            st.setInt(4,percentuale_cashback);

            int rs = st.executeUpdate();
            st.close();
            return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public void setPercentuale(int id_cliente, int percenutale) {
        String query = "UPDATE cliente set percentuale_cashback=? where id=?";
        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setInt(1,percenutale);
            st.setInt(2,id_cliente);

            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Cliente getClienteById(int id) {
        String query = "SELECT * FROM cliente WHERE id_cliente=?";
        Cliente cliente = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                Date data_registrazione = resultSet.getDate("data_registrazione");
                int percentuale_cashback = resultSet.getInt("percentuale_cashback");
                int cap = resultSet.getInt("cap");
                int capMensile = resultSet.getInt("cap_mensile");
                cliente = new Cliente(id, nome, cognome, data_registrazione, percentuale_cashback, cap, capMensile);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
    @Override
    public List<Cliente> getAllClienti() {
        String query = "SELECT * FROM cliente order by id_cliente";
        List<Cliente> clienti = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id_cliente"),  rs.getString("nome"), rs.getString("cognome"), rs.getDate("data_registrazione"), rs.getInt("percentuale_cashback"), rs.getInt("cap"),rs.getInt("cap_mensile"));
                clienti.add(cliente);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clienti;
    }
}
