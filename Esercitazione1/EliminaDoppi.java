/* scrivere il metodo eliminaDoppi che riceve in input un array a di interi, dove ciascun intero ha
un valore compreso tra 0 e 9; il metodo restituisce un nuovo array contenente tutti gli interi di a,
ma non ripetuti */
package Esercitazione1;

import IO.*;
public class EliminaDoppi {
    //funzione ausiliaria
    public static boolean contains(int[] a, int x) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == x) {
                return true;
            }
        }

        return false;
    }


    public static int[] eliminaDoppi(int[] a) {
        int[] b = new int[a.length]; //non conosco la lunghezza, ma sarà al massimo lungo quanto a

        int j = 0;
        for (int i=0; i<a.length; i++) {
            if (!contains(b, a[i])) {
                b[j] = a[i];
                j++;
            }
        }
        //ma adesso ho l'array b contenente degli zeri alla fine (ha lunghezza pari ad a), quindi
        //siccome in j ho l'informazione di quanti elementi ho in b

        int[] c = new int[j];   //creo un array di lunghezza j
        for (int i=0; i<j; i++) {
            c[i] = b[i];
        }

        return c;
    }


    public static void main(String[] args) {
        int[] array = {2, 3, 3, 4};

        int[] nuovoArray = eliminaDoppi(array);

        for (int i=0; i<nuovoArray.length; i++) {
            IO.println(nuovoArray[i]);
        }
    }
}
