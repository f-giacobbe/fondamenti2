package Lezione4;

import IO.*;
public class Esercizio5 {
    public static void main(String[] args) {
        //Popolare un vettore da input e scrivere in output la sequenza inversa
        int[] vettore = new int[IO.readInt("Digita dimensione vettore: ")];

        for (int i=0; i<vettore.length; i++) {
            vettore[i] = IO.readInt("Digita valore da inserire in posizione " + i + ": ");
        }

        for (int i=vettore.length-1; i>=0; i--) {
            IO.print(vettore[i] + ";");
        }
    }
}
