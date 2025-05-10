/* Scrivere una funzione che restituisce la media dei valori maggiori di x presente nel vettore,
 * se non ne esistono, restituisce 0
 */

package Lezione5;

import IO.*;
public class Esercizio10 {
    public static float mediaX(int[] array, int x) {
        int somma = 0;
        int valoriValidi = 0;

        for (int i=0; i<array.length; i++) {
            if (array[i] > x) {
                somma += array[i];
                valoriValidi++;
            }
        }

        //se nessun valore è maggiore di x
        if (valoriValidi == 0) {
            return 0f;
        }

        return (((float)(somma))/valoriValidi);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 15, 20, 8, 11};

        IO.println(mediaX(a, 14));
        IO.println(mediaX(a, 50));
    }
}
