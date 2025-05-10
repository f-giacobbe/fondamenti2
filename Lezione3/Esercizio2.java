package Lezione3;
import IO.*;
public class Esercizio2 {
    public static void main(String[] args) {
        /* leggere da input un intero n e una sequenza di n numeri interi. Restituire il numero dei valori nella sequenza
        maggiori del loro predecessore. */

        int lunghezzaS = IO.readInt("Quanti numeri vuoi inserire?: ");
        int numeriValidi = 0;
        int ultimoNumero = 0;

        for (int i=0; i<lunghezzaS; i++) {
            int n = IO.readInt("Digita numero: ");

            if  (i!=0 && n>ultimoNumero) {
                numeriValidi ++;
            }

            ultimoNumero = n;
        }

        IO.println("I numeri che hai inserito maggiori dei loro predecessori sono: " + numeriValidi);
    }
}