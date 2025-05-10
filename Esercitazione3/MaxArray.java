/* funzione ricorsiva che riceve in input un array a di interi e restituisce il valore massimo
 * l'array iniziale non è mai vuoto
 */

package Esercitazione3;
import IO.*;
public class MaxArray {
    public static int maxArray(int[] a) {
        return maxArray(a, 1, a[0]);
    }



    private static int maxArray(int[] a, int i, int max) {
        if (i == a.length) {
            return max;
        }

        if (a[i] > max) {
            return maxArray(a, i+1, a[i]);
        }

        return maxArray(a, i+1, max);
    }



    public static void main(String[] args) {
        int[] a = {5, 3, 9};

        IO.println(maxArray(a));
    }
}
