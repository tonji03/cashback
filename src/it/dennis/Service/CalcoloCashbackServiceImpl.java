package it.dennis.Service;

import it.dennis.Model.Acquisto;
import it.dennis.Model.Cliente;
import it.dennis.Repository.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CalcoloCashbackServiceImpl implements CalcoloCashback {
    ClienteDAO clienteDAO = new ClienteDAOImpl();
    AcquistoDAO acquistoDAO = new AcquistoDAOImpl();
    CashbackddDAO cashbackddDAO = new CashbackDAOImpl();

    public List<Cliente> getAllClienti(){
        return clienteDAO.getAllClienti();
    }
    public List<Acquisto> getAllAcquisti(){
        return acquistoDAO.getAllAcquisti();
    }

    @Override
    public void calcolaCashback(){
        List<Acquisto> acquistoList = acquistoDAO.getAllAcquisti();
        List<Cliente> clienti = clienteDAO.getAllClienti();
        int counter = 0;
        while (!acquistoList.isEmpty()){

            Acquisto acquisto = acquistoList.get(counter);
            int id_acquisto = acquisto.getId_acquisto();
            int id_cliente = acquisto.getId_cliente();
            Date data_acquisto = acquisto.getData_acquisto();
            double totPremio = 0;
            double premio=0;

            while(id_cliente == acquisto.getId_cliente() && data_acquisto == acquisto.getData_acquisto()){
                Cliente c = clienteDAO.getClienteById(id_cliente);
                double prezzo = acquisto.getPrezzo();
                double percentuale = c.getPercentuale_cashback();
                premio = prezzo * (percentuale/100);

                if(premio <= c.getCap()){
                    totPremio+=premio;
                }
                try{
                    acquisto = acquistoList.get(counter++);
                }catch (IndexOutOfBoundsException e){
                    System.out.println("Counter fuori bound");
                }

            }

            cashbackddDAO.insert(id_cliente, totPremio, Date.valueOf(LocalDate.now()));

        }
    }
    @Override
    public void impostaPercentualeCashback(){
        List<Cliente> clienti = new ArrayList<Cliente>();
        clienti = clienteDAO.getAllClienti();
        clienti.forEach(cliente -> {
            if(!dataMinoreAnno(cliente.getData_registrazione())){
                clienteDAO.setPercentuale(cliente.getId_cliente(),12);
            }else{
                clienteDAO.setPercentuale(cliente.getId_cliente(),10);
            }
        });
    }
    private boolean dataMinoreAnno(Date date){
        LocalDate oggi = LocalDate.now();
        LocalDate data = date.toLocalDate();
        Period period = Period.between(data, oggi);
        int anni = period.getYears();

        return anni < 1;
    }
}
