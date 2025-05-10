/* scrivere un metodo che riceve due stringhe e restituisce il numero totale di occorrenze della
 * seconda stringa all'interno della prima
 */
package Esercitazione2;

import IO.*;
public class Occorrenze {
    public static int occorrenze(String a, String b) {
        if (a.length() < b.length()) {
            return 0;
        }

        int cnt = 0;
        int n = b.length();

        for (int i=0; i<=a.length()-n; i++) {
            if ((a.substring(i, i+n)).equals(b)) {
                cnt++;
            }
        }

        return cnt;
    }



    public static void main(String[] args) {
        String a = "ciao";
        String b = "ciaociaoo";

        IO.println(occorrenze(b, a));
    }
}
