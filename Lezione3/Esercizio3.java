package Lezione3;

import IO.*;
public class Esercizio3 {
    public static void main(String[] args) {
        /* leggere da input un intero n e una sequenza di n numeri interi. Quindi stampare il valore medio dei valori
        nella sequenza */

        int lunghezzaS = IO.readInt("Quanti valori vuoi inserire?: ");
        int somma = 0;
        float media;

        for (int i=0; i<lunghezzaS; i++) {
            somma += IO.readInt("Digita numero: ");
        }

        media = ((float)(somma)) / lunghezzaS;

        IO.println("La media dei valori che hai inserito è: " + media);
    }
}
