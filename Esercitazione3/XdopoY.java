/* funzione ricorsiva che riceve un array a di interi e due valori interi x e y. Restituisce true
 * se ogni occorrenza di x è seguita da un'occorrenza di y, false altrimenti
 */
package Esercitazione3;

import IO.*;
public class XdopoY {
    public static boolean xdopoy(int[] a, int x, int y) {
        if (a.length == 0) {
            return true;
        }

        return xdopoy(a, x, y, 0);
    }



    private static boolean xdopoy(int[] a, int x, int y, int i) {
        if (i == a.length-1) {
            if (a[i] == x) {
                return false;
            }
            
            return true;
        }

        if (a[i] == x && a[i+1] != y) {
            return false;
        }

        return xdopoy(a, x, y, i+1);
    }



    public static void main(String[] args) {
        int[] a = {2, 5, 3, 6, 2, 5, 3};

        IO.println(xdopoy(a, 5, 3));
    }
}
