package Lezione3;

import IO.*;
public class Somma_numeri {
    public static void main(String[] args) {
        /*leggere una sequenza di 5 numeri, farne la somma e visualizzarla */

        int somma = 0;

        for (int i=0; i<5; i++) {
            int n = IO.readInt("Dammi un numero: ");
            somma = somma + n;
        }

        IO.println("La somma dei 5 numeri è " + somma);


        //!!!!!  IO.println("L'ultimo numero letto è" + n);  !!!!!
        /*questo NON POSSO FARLO, in quanto n è stato dichiarato dentro il ciclo for
         * IN GENERALE, in Java, una variabile creata dentro un ciclo for, ad esempio, muore non appena il blocco
         * termina
         * 
         * se invece ci serviva sapere l'ultimo valore di n fuori dal for, allora avremmo dovuto semplicemente
         * dichiarare con <int n = 0;> la variabile n fuori dal for, proprio come avevamo fatto con somma
         */


        int somma2 = 0;
        int n2 = 0; /*importante = 0 in quanto alla compilazione Java non verifica se il ciclo for viene eseguito
                    * va non solo dichiarato, ma anche INIZIALIZZATO */
        for (int i = 0; i < 5; i++) {
            n2 = IO.readInt("Digita numero: ");
            somma2 = somma2 + n2;
        }
        IO.println("La somma dei numeri è " + somma2 + " e l'ultimo valore digitato è " + n2);
    }
}

//anche se avremmo dovuto scegliere un LONG