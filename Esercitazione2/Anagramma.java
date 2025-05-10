/* scrivere un metodo che riceva in input una stringa s ed un array a di stringhe
 * e restituisce un numero che indica quante stringhe presenti nell'array a sono un anagramma della
 * stringa s
 */


package Esercitazione2;
import IO.*;
public class Anagramma {
    public static int occorrenze(char c, String s) {
        int res = 0;

        for (int i=0; i<s.length(); i++) {
            if (c == s.charAt(i)) {
                res++;
            }
        }

        return res;
    }



    public static int anagrammaCounter(String s, String[] a) {
        int res = 0;
        boolean valid = false;
        int j = 0;

        //itero sulle stringhe dell'array
        for (int i=0; i<a.length; i++) {
            if (s.length() != a[i].length()) {
                continue;
            }

            //itero sui caratteri
            valid = true;
            j = 0;
            while (valid && j<s.length()) {
                if (occorrenze(s.charAt(j), s) != occorrenze(s.charAt(j), a[i])) {
                    valid = false;
                }
                j++;
            }

            if (valid) {
                res++;
            }
        }

        return res;
    }



    public static void main(String[] args) {
        String s = "ciao";
        String[] a = {"aoic", "icoa", "nono", "ciio", "ciaa", "ciaoo", "ciao"};

        IO.println(anagrammaCounter(s, a));
    }
}
