package Lezione4;

import IO.*;
public class Esercizio7 {
    public static void main(String[] args) {
         /*Popolare un vettore da input e contare quanti elementi sono maggiori del predecessore o del successore
            (o entrambi)  */

        int[] vettore = new int[IO.readInt("Digita dimensione vettore: ")];
        int counter = 0;

        for (int i=0; i<vettore.length; i++) {
            vettore[i] = IO.readInt("Digita valore: ");
        }

        for (int i=0; i<vettore.length; i++) {
            if ((i > 0) && (vettore[i] > vettore[i-1])) {
                counter ++;
            }
            else {
                if ((i < vettore.length-1) && (vettore[i] > vettore[i+1])) {
                    counter++;
                }
            }
        }

        IO.println(counter);
    }
}
