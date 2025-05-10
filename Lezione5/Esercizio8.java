/* fare una funzione che preso in input un array di interi ne restituisce il massimo */

package Lezione5;
import IO.*;
public class Esercizio8 {
    public static int massimoArray(int[] array) {
        int massimo = 0;
        
        for (int i=0; i<array.length; i++) {
            if (array[i] > massimo) {
                massimo = array[i];
            }
        }

        return massimo;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 1, 9, 5, 10, 8};
        IO.println(massimoArray(a));
    }
}
