/* palindromo su vettore di stringhe (ricorsiva), visualizzando i record di attivazione (disegno) */

package Lezione8;

import IO.*;
public class Esercizio16 {
    public static boolean isPalindrome(String[] a, int i) {
        if (i==a.length/2) {
            return true;
        }

        if (!(a[i].equals(a[a.length-i-1]))) {
            return false;
        }

        return isPalindrome(a, i+1);
    }



    public static boolean isPalindrome(String[] a) {
        return isPalindrome(a, 0);
    }



    public static void main(String[] args) {
        String[] a = {"casa", "albero", "albero", "casa"};
        String[] b = {"casa", "albero", "albero", "culo"};

        IO.println(isPalindrome(a));
        IO.println(isPalindrome(b));
    }
}
