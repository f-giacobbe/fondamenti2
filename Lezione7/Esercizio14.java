/* Metodo che prende due vettori di stringhe e verifica se sono uguali */

package Lezione7;

import IO.*;
public class Esercizio14 {
    
    public static boolean sonoUguali(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i=0; i<a.length; i++) {
            if (!(a[i].equals(b[i]))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String[] a = {"ciao", "casa", "albero"};
        String[] b = {"ciao", "casa", "albero"};

        IO.println(sonoUguali(a, b));
    }
}
