//invertire l'ordine di un array
package Esercitazione1;

import IO.*;
public class InvertiArray {

    //restituendo un nuovo array, ma invertito
    public static int[] invertiArray(int[] a0) {
        int[] a1 = new int[a0.length];

        for (int i=0; i<a0.length; i++) {
            a1[i] = a0[a0.length-i-1];
        }

        return a1;
    }


    //invertendo l'array già presente
    public static void invertiArray2(int[] a) {
        //utilizzo comunque un array d'appoggio
        int[] a1 = new int[a.length];

        for (int i=0; i<a.length; i++) {
            a1[i] = a[a.length-i-1];
        }

        for (int i=0; i<a.length; i++) {
            a[i] = a1[i];
        }
    }



    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        invertiArray2(array);
        
        for (int i=0; i<array.length; i++) {
            IO.print(array[i] + " ");
        }
    }
}
