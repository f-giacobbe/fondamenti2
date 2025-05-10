/* scrivere un metodo che riceva un array di stringhe e restituisca una stringa risultato che è la
 * concatenazione di tutte le stringhe dell'array in posizione dispari separate da uno spazio
 */

package Esercitazione2;

import IO.*;
public class ConcatenaDispari {
    public static String concatenaDispari(String[] s) {
        String res = "";

        for (int i=1; i<s.length; i+=2) {
            res += s[i] + " ";
        }

        return res;
    }



    public static void main(String[] args) {
        String[] a = {"ciao", "come", "stai", "bene"};

        IO.println(concatenaDispari(a));
    }
}
