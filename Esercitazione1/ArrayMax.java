/* scrivere un metodo che prende in ingresso tre array di interi a b c, aventi la stessa dimensione
 * e restituisce un nuovo array, sempre della stessa dimensione, tale che in ogni posizione i è contenuto
 * il valore massimo tra a[i], b[i] e c[i]
 */
package Esercitazione1;
import IO.*;
public class ArrayMax {
    public static int[] arrayMax(int[] a, int[] b, int[] c) {
        int[] d = new int[a.length];

        for (int i=0; i<a.length; i++) {
            int massimo = a[i];
            if (b[i] > massimo) {
                massimo = b[i];
            }
            if (c[i] > massimo) {
                massimo = c[i];
            }

            d[i] = massimo;
        }

        return d;
    }


    public static void main(String[] args) {
        int[] a1 = {1, 10, 90};
        int[] a2 = {2, 9, 1};
        int[] a3 = {0, 11, 10};

        int[] max = arrayMax(a1, a2, a3);

        for (int i=0; i<max.length; i++) {
            IO.println(max[i]);
        }
    }
}
