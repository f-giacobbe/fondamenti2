/* Scrivere un metodo che prende come argomento una matrice e restituisce l'indice di una riga che contiene
    il valore massimo presente nella matrice */

package Lezione6;
import IO.*;
public class Esercizio11 {
    public static int rigaConMassimoMatrice(int[][] m) {
        int indiceMassimo = 0;
        int valoreMassimo = m[0][0];

        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                if (m[i][j] > valoreMassimo) {
                    valoreMassimo = m[i][j];
                    indiceMassimo = i;
                }
            }
        }

        return indiceMassimo;
    }



    public static void main(String[] args) {
        int[][] matrice = {
            {1, 2, 3, 4},
            {5, 6, 15, 8},
            {11, 10, 9, 8}
        };

        IO.print(rigaConMassimoMatrice(matrice));
    }
}