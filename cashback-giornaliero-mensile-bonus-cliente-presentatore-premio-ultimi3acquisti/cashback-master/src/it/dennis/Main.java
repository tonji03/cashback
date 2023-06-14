package it.dennis;

import it.dennis.Service.CalcoloCashbackServiceImpl;
import it.dennis.Service.ClienteService;
import it.dennis.Service.ClienteServiceImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CalcoloCashbackServiceImpl calcoloCashbackService = new CalcoloCashbackServiceImpl();
        //calcoloCashbackService.calcolaCashbackMensile();
        //calcoloCashbackService.calcolaCashback();
        //calcoloCashbackService.bonusClientePresentatore();
        //calcoloCashbackService.calcoloPremioUltimi3Acquisti();
        ClienteService clienteService = new ClienteServiceImpl();
        //System.out.println(Integer.valueOf(args[0])+" "+String.valueOf(args[1]));
        //clienteService.updateCodiceSocieta(Integer.valueOf(args[0]),String.valueOf(args[1]));
    }
}