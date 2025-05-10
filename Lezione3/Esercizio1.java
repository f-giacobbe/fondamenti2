package Lezione3;
import IO.*;
public class Esercizio1 {
    public static void main(String[] args) {
        /*leggere da input un intero n e una sequenza di n numeri interi. Restituire il numero dei valori nella sequenza
        maggiori di 8. */

        int lunghezzaS = IO.readInt("Quanti numeri vuoi inserire?: ");
        int numeriValidi = 0;

        for (int i=0; i<lunghezzaS; i++) {
            int n = IO.readInt("Digita numero: ");

            if (n > 8) {
                numeriValidi ++;
            }
        }

        IO.println("Il numero di valori che hai inserito che sono maggiori di 8 sono "+numeriValidi);
    }
}