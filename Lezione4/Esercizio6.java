package Lezione4;

import IO.*;
public class Esercizio6 {
    public static void main(String[] args) {
        //Popolare un vettore da input e verificare se è simmetrico
       
        int[] vettore = new int[IO.readInt("Digita dimensione vettore: ")];
        boolean simmetrico = true;

        for (int i=0; i<vettore.length; i++) {
            vettore[i] = IO.readInt("Digita valore: ");
        }

        int i = 0;
        while (simmetrico && i<(vettore.length/2)) {
            if (vettore[i] != vettore[vettore.length-i-1]) {
                simmetrico = false;
            }
            i++;
        }

        IO.println(simmetrico);
    }
}
