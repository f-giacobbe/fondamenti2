package Lezione3;

import IO.*;
public class Esercizio4 {
    public static void main(String[] args) {
        /* leggere da input un intero n e una sequenza di n numeri interi. Quindi stampare il minimo tra i valori
        maggiori di 8 (si stampi una stringa opportuna qualora non esistano valori maggiori di 8) */

        int lunghezzaS = IO.readInt("Quanti valori vuoi inserire?: ");
        int minimo = 0;

        for (int i=0; i<lunghezzaS; i++) {
            int n = IO.readInt("Digita numero: ");

            //inizializzo al primo valore utile
            if ((minimo == 0) && (n > 8)) {
                minimo = n;
            }
            else {
                if ((n > 8) && (n < minimo)) {
                    minimo = n;
                }
            }
        }

        //se nessun numero inserito è valido
        if (minimo == 0) {
            IO.println("Nessun numero tra quelli che hai inserito è maggiore di 8.");
        }
        else {
            IO.println("Il numero minimo tra quelli che hai inserito (maggiori di 8) è: " + minimo);
        }
    }
}