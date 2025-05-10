/* supponiamo di avere un array di interi, verificare ricorsivamente se è palindromo */

package Lezione8;

import IO.*;
public class PalindromoRicorsivo {
    //vero metodo ricorsivo
    public static boolean isPalindrome(int[] a, int i) {
        //caso base, ho raggiunto la metà dell'array
        if (i==a.length/2) {
            return true;
        }

        if (a[i] != a[a.length-i-1]) {
            return false;
        }

        return isPalindrome(a, i+1);
    }



    public static boolean isPalindrome(int[] a) {
        return isPalindrome(a, 0);
    }



    //metodo diverso, passando come argomento solo l'array (senza i) - ma meno efficiente
    //a ogni chiamata ricorsiva passo un nuovo vettore, quindi come caso base uso la sua lunghezza
    public static boolean isPalindromeBIS(int[] a) {
        //caso base
        if (a.length == 1) {
            return true;
        }

        if (a.length == 2) {
            return (a[0] == a[1]);
        }

        if (a[0] != a[a.length-1]) {
            return false;
        }

        //creo un nuovo array
        int[] b = new int[a.length-2];
        //copio su b tutti gli elementi di a tranne il primo e l'ultimo
        for (int i=0; i<b.length; i++) {
            b[i] = a[i+1];
        }

        return isPalindromeBIS(b);
    }



    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {1, 2, 2, 1};
        int[] c = {1, 2, 2, 4};

        IO.println(isPalindrome(a));
        IO.println(isPalindrome(b));
        IO.println(isPalindrome(c));
    }
}
