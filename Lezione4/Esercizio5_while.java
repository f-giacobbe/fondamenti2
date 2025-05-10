package Lezione4;

import IO.*;
public class Esercizio5_while {
    public static void main(String[] args) {
        /* leggere da input un intero n e una sequenza di n numeri interi. Restituire il numero dei valori nella sequenza
        maggiori del loro predecessore. */

        int lunghezzaS = 0;
        boolean inputValido = false;

        //check input valido
        while (!inputValido) {
            lunghezzaS = IO.readInt("Quanti numeri vuoi inserire?: ");

            if (lunghezzaS <= 0) {
                IO.println("Input non valido, riprova");
            }
            else {
                inputValido = true;
            }
        }

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