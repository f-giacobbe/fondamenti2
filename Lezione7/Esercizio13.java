/* Scrivere un metodo che restituisce un booleano che verifica se due array sono uguali (come contenuto)
    (prima assicurarsi che abbiano la stessa dimensione chiaramente) */

package Lezione7;
import IO.*;
public class Esercizio13 {
    
    public static boolean sonoUguali(int[] a, int[] b) {
        //verifica dimensione
        if (a.length != b.length) {
            return false;
        }

        for (int i=0; i<a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4};

        IO.println(sonoUguali(a, b));
    }
}
