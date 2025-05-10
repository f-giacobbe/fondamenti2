/* Scrivere un metodo che prende come argomento una matrice e restituisce un vettore che contiene gli
    indici delle righe che contengono il valore massimo presente nella matrice */

package Lezione6;

import IO.*;
public class Esercizio12 {

    public static int[] vettoreMaxMatrice(int[][] m) {
        int[] arrayRes = new int[m.length];
        int cnt = 0;
        
        //calcolo il valore massimo
        int valoreMassimo = m[0][0];
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                if (m[i][j] > valoreMassimo) {
                    valoreMassimo = m[i][j];
                }
            }
        }
        
        //inserisco le righe contenenti valoreMassimo all'array arrayRes
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                if (m[i][j] == valoreMassimo) {
                    arrayRes[cnt] = i;
                    cnt++;
                    break;
                }
            }
        }

        //creo nuovo array da restituire, in caso sia più corto di m.length
        if (cnt == m.length) {
            return arrayRes;
        }
        else {
            int[] arrayResNew = new int[cnt];

            for (int i=0; i<cnt; i++) {
                arrayResNew[i] = arrayRes[i];
            }

            return arrayResNew;
        }
    }


    public static void main(String[] args) {
        int[][] matrice = {
            {1, 2, 15, 4},
            {5, 6, 0, 8},
            {11, 15, 9, 8}
        };

        int[] arrayMax = vettoreMaxMatrice(matrice);

        for (int i=0; i<arrayMax.length; i++) {
            IO.print(arrayMax[i] + " ");
        }
    }
}
