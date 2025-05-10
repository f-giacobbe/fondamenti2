/* calcolare la somma di un array di interi */
package Esercitazione1;

import IO.*;
public class SommaArray {
    public static int sommaA(int[] a) {
      int somma = 0;

      for (int i=0; i<a.length; i++) {
        somma += a[i];
      }

      return somma;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        IO.println(sommaA(array));
    }
}