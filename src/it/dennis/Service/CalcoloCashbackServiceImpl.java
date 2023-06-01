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
        List<Acquisto> acquistoList = getAllAcquisti();
        int counter = 0;
        boolean listaAcquistoFinita = false;
        while (!acquistoList.isEmpty() && !listaAcquistoFinita){

            Acquisto acquisto = acquistoList.get(counter);
            int id_cliente = acquisto.getId_cliente();
            double totPremio = 0;
            double premio=0;
            //finchè la lista acquisti non è finiita e l'id_cliente è uguale all'acquisto selezionato e la data è uguale alla data dell'acquisto selezionato
            while(!listaAcquistoFinita && id_cliente == acquisto.getId_cliente() && acquisto.getData_acquisto().getMonth()+1 == LocalDate.now().getMonthValue()){
                //prendo il cliente in base all'id_cliente dell'acquisto
                Cliente c = clienteDAO.getClienteById(id_cliente);
                if(c != null ){ //se il cliente è vuoto passa all'acquisto successivo perchè non deve calcolare il cashback di un utente non registrato
                    double prezzo = acquisto.getPrezzo(); //prezzo d'acquisto
                    premio = prezzo * ((double) c.getPercentuale_cashback() /100); //calcolo cashback
                    //se il premio è minore uguale del cap e il premio totale è minore del cap
                    if(premio <= c.getCap() ){
                        totPremio+=premio;//aggiunge al premio totale il cashback calcolato
                    }else if(premio > c.getCap()){//se il premio supera il cap lo pone uguale al cap
                        totPremio+=c.getCap();

                    }
                    if(totPremio>c.getCapMensile()){
                        totPremio=c.getCapMensile();
                    }
                    try{
                        acquisto = acquistoList.get(++counter);
                    //passa all'acquisto successivo provando ad aumentare il counter,
                    // se il counter va oltre pone la variabile a true per indicare che la lista è finita
                    }catch (IndexOutOfBoundsException e){
                        listaAcquistoFinita = true;
                    }
                }else{
                    acquisto = acquistoList.get(++counter);
                }

            }//se l'id cliente è diverso da nullo, ma dato che è un intero il valore nullo equivale a 0, inserisce il premio nella tabella cashback col relativo id_cliente associato
            if(id_cliente!=0 && totPremio!=0){
                insertIntoCashback(id_cliente, totPremio);
            }//se il mese è diverso prova a ottenere il prossimo acquisto in lista
            if(acquisto.getData_acquisto().getMonth()+1 != LocalDate.now().getMonthValue()){
                try{
                    acquisto = acquistoList.get(++counter);
                    //passa all'acquisto successivo provando ad aumentare il counter,
                    // se il counter va oltre pone la variabile a true per indicare che la lista è finita
                }catch (IndexOutOfBoundsException e){
                    listaAcquistoFinita = true;
                }
            }
        }
    }
    public void insertIntoCashback(int id_cliente, double totPremio){
        cashbackddDAO.insert(id_cliente, totPremio, Date.valueOf(LocalDate.now()));
    }
    @Override
    public void impostaPercentualeCashback(){
        List<Cliente> clienti = new ArrayList<Cliente>();
        clienti = clienteDAO.getAllClienti();//aggiunge tutti i clienti nella lista
        clienti.forEach(cliente -> { //per ogni cliente se la data è minore uguale a un anno pone la percentuale a 10 altrimenti se maggiore di un anno pone a 12 la percentuale del cliente
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
