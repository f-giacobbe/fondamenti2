package Lezione5;

import IO.*;
public class Funzione {

    //funzione che stampa un array
    public static void stampaArray(int[] arraydastampare) {
        IO.print("[");

        for (int i=0; i<arraydastampare.length; i++) {
            IO.print(arraydastampare[i]);

            if (i < arraydastampare.length - 1) {
                IO.print(";");
            }
        }

        IO.print("]\n");
    }

    //main
    public static void main(String[] args) {
        int[] ai = {6, 3, 8, 2};
        int[] ai2 = {3, 4, 1, 7};

        /* IMPORTANTE - se provassimo a stampare semplicemente l'array, ci verrebbe restituito solo
         * l'indirizzo di memoria
         */
        IO.println(ai);


        //CHIAMATA DI FUNZIONE
        stampaArray(ai);
        stampaArray(ai2);
    }
}