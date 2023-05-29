package it.dennis;

import it.dennis.Service.CalcoloCashbackServiceImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CalcoloCashbackServiceImpl calcoloCashbackService = new CalcoloCashbackServiceImpl();
        calcoloCashbackService.impostaPercentualeCashback();
        System.out.println(calcoloCashbackService.getAllAcquisti());
        calcoloCashbackService.calcolaCashback();

    }
}