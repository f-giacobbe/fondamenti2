package Lezione3;

import IO.*;
public class Somma_compatta {
    public static void main(String[] args) {
        int somma = 0;

        for (int i=0; i<5; i++) {
            somma += IO.readInt(("Digita numero: "));
        }

        IO.println("La somma è " + somma);
    }
}
