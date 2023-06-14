package it.dennis.Service;

import it.dennis.Model.Cashback;
import it.dennis.Model.Cliente;
import it.dennis.Repository.CashbackDAOImpl;
import it.dennis.Repository.CashbackddDAO;
import it.dennis.Repository.ClienteDAO;

import java.util.List;

public class InvioMailServiceImpl {

    CashbackddDAO cashbackDAO;
    ClienteDAO clienteDAO;
    public void scorriListaSumCashback(){
        List<Cashback> cashbacks = cashbackDAO.getAllCashbackSum();
        for (Cashback cashback : cashbacks) {
            Cliente cliente = clienteDAO.getClienteById(cashback.getId_cliente());
            double totale = cashback.getTotale_cashback();
            String nome = cliente.getNome();
            String cognome = cliente.getCognome();
            mandaMail(totale,nome,cognome);
        }
    }

    public void mandaMail(double totale,String nome,String cognome){
        String messaggio = nome+" "+cognome+"\nVerrà erogato entro trimestre successivo €"+totale;

    }
}
