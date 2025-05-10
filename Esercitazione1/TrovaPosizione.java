//trovare la posizione di un elemento di un array
package Esercitazione1;

import IO.*;
public class TrovaPosizione {
    public static int posizione(int[] a, int x) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        IO.println(posizione(a, 2));
    }
}
