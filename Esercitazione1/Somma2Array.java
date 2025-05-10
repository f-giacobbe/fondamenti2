//calcolare la somma di due array, elemento per elemento (a1 e a2 hanno la stessa lunghezza)
package Esercitazione1;

import IO.*;
public class Somma2Array {
    public static int[] sommaDue(int[] a1, int[] a2) {
        int[] a = new int[a1.length];

        for (int i=0; i<a1.length; i++) {
            a[i] = a1[i] + a2[i];
        }

        return a;
    }


    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int[] arraySomma = sommaDue(array1, array2);

        for (int i=0; i<arraySomma.length; i++) {
            IO.print(arraySomma[i] + " ");
        }
    }
}
