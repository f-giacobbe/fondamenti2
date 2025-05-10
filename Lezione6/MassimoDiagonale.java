/* leggere da input una matrice (Verificando sia quadrata) e restituire il valore massimo della diagonale */

package Lezione6;

import IO.*;
public class MassimoDiagonale {
    public static void leggiMatrice(int[][] arg) {
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg.length; j++) {
                arg[i][j] = IO.readInt("Digita valore riga " + i + " colonna " + j + ": ");
            }
        }
    }


    public static int massimoDiagonale(int[][] arg) {
        int massimo = arg[0][0];

        for (int i = 1; i < arg.length; i++) {
            if (arg[i][i] > massimo) {
                massimo = arg[i][i];
            }
        }

        return massimo;
    }


    public static void main(String[] args) {
        int dimensione = IO.readInt("Digita dimensione matrice: ");
        int[][] a = new int[dimensione][dimensione];
        leggiMatrice(a);

        IO.println(massimoDiagonale(a));
    }
}
