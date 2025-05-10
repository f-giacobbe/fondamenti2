package Lezione3;

import IO.*;
public class Somma_n_negativi {
    public static void main(String[] args) {
        /* leggere 5 numeri (anche negativi) e visualizzare il massimo tra i 5 */

        long max = 0;

        for (byte i=0; i<5; i++) {
            long n = IO.readLong("Digita numero: ");

            //inizializzo con il primo valore (solo alla prima iterazione)
            if (i == 0 || n > max) {
                max = n;
            }

        }
        
        IO.println("Il valore massimo inserito è " + max);
    }
}
