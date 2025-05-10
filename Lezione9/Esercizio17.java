/* scrivere un metodo ricorsivo che prende in input un array di stringhe e restituisce la lunghezza
    della sottosequenza di lunghezza massima ordinata in senso crescente. Le stringhe null vanno
    saltate */
    
package Lezione9;
import IO.*;
public class Esercizio17 {
    public static int sequenzaMax(String[] a) {
        if (a == null || a.length == 0 || (a.length == 1 && a[0] == null)) {
            return 0;
        }

        return sequenzaMax(a, 0, 1, 1);
    }



    private static int sequenzaMax(String[] a, int i, int maxAbs, int maxLocal) {
        if (i == a.length-1) {
            return maxAbs;
        }

        /*if (a[i] == null || a[i+1] == null || a[i].compareTo(a[i+1]) > 0) {
            return sequenzaMax(a, i+1, maxAbs, 1);   //azzero il massimo locale
        }
        */

        if (a[i] == null || a[i+1] == null || confrontaStringhe(a[i], a[i+1]) > 0) {
            return sequenzaMax(a, i+1, maxAbs, 1);   //azzero il massimo locale
        }

        return sequenzaMax(a, i+1, maxLocal+1 > maxAbs ? maxLocal+1 : maxAbs, maxLocal+1);
    }



    //oppure senza il compareTo, uso una funzione ausiliaria ricorsiva
    // che confronta le stringhe carattere per carattere
    public static int confrontaStringhe(String a, String b) {
        //restituisce -1 se a precede b; 0 se sono uguali; 1 se a viene dopo di b
        return confrontaStringhe(a, b, 0);
    }



    private static int confrontaStringhe(String a, String b, int i) {
        if (a.charAt(i) < b.charAt(i)) {
            return -1;
        }

        if (a.charAt(i) > b.charAt(i)) {
            return 1;
        }

        //caratteri i-esimi uguali - ultima lettera di una delle due parole
        if (i == a.length()-1 || i == b.length()-1) {
            if (a.length() < b.length()) {
                return -1;
            }
            
            if (a.length() > b.length()) {
                return 1;
            }

            //stessa lunghezza
            return 0;
        }

        //caratteri i-esimi uguali - non ultima lettera
        return confrontaStringhe(a, b, i+1);
    }



    public static void main(String[] args) {
        String[] a = {"a", "b", "a", "e", "f", "f", null, "c", null};      //deve restituire 3, ovvero la lunghezza di aef

        IO.println(sequenzaMax(a));
    }
}
