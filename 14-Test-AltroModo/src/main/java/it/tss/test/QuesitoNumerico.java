/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.test;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class QuesitoNumerico extends Quesito<Integer> {

    public QuesitoNumerico(String domanda, Integer esatta) {
        super(domanda, esatta);
    }

    @Override
    public int ask() {
        System.out.println("--------------------------------------------");
        System.out.println(getDomanda());
        int punteggio = 0;
        boolean error;
        do {
            try {
                error = false;
                Object risp = readRisposta(scanner, this);
                System.out.println("hai risposto: " + risp);
                punteggio = Objects.equals(esatta, risp) ? 10 : 0;
                System.out.println("punteggio -> " + punteggio);
            } catch (Exception ex) {
                System.err.println("risposta non accettata");
                error = true;
                scanner.nextLine();
            }
        } while (error);
        return punteggio;
    }

}
