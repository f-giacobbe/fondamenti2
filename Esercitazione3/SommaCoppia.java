/* funzione ricorsiva che riceve un array a di interi contenente un numero pari di elementi
 * ed un parametro x di tipo int e restituisce true se la somma di ogni coppia contigua di elementi è
 * uguale a x, false altrimenti
 */
package Esercitazione3;

import IO.*;
public class SommaCoppia {
    public static boolean sommaCoppia(int[] a, int x) {
        if (a.length == 0) {
            return true;
        }

        return sommaCoppia(a, x, 0);
    }



    private static boolean sommaCoppia(int[] a, int x, int i) {
        if (i == a.length) {
            return true;
        }

        if (a[i] + a[i+1] != x) {
            return false;
        }

        return sommaCoppia(a, x, i+2);
    }



    public static void main(String[] args) {
        int[] a = {2, 3, -1- 6};

        IO.println(sommaCoppia(a, 5));
    }
}
