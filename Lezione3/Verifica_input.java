package Lezione3;

import IO.*;
public class Verifica_input {
    public static void main(String[] args) {
        int lunghezzaS = IO.readInt("Di quanti numeri devo calcolare il massimo? ");

        //verifica input corretto utente (lunghezzaS <= 0)
        if (lunghezzaS <= 0) {
            IO.println("Valore non valido");
        }
        else {
            int max = 0;

            for (int i=0; i<lunghezzaS; i++) {
                int n = IO.readInt("Digita numero: ");

                if (i == 0 || n > max) {
                    max = n;
                }
            }

            IO.println("Il valore massimo inserito è " + max);
        }
    }
}
