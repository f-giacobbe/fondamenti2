/* due stringhe si dicono simili se esse coincidono in almeno p posizioni, dove p è la metà troncata
 * della lunghezza della stringa più corta (es. abcdefabcdef e zbcaafacz sono simili perché coincidono
 * negli indici 1, 2, 5, 6, e p=4).
 * Scrivere un metodo che riceva una matrice A di stringhe e restituisca true se almeno una colonna di A
 * contiene due stringhe simili
 */

package Esercitazione2;

import IO.*;
public class Simili {
    public static boolean simili(String a, String b) {
        int n = 0;
        int p = 0;
        int cnt = 0;

        if (a.length() >= b.length()) {
            p = b.length()/2;
            n = b.length();
        }
        else {
            p = a.length()/2;
            n = a.length();
        }


        for (int i=0; i<n; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                cnt++;
            }
        }


        if (cnt >= p) {
            return true;
        }
        else {
            return false;
        }
    }



    public static boolean simili(String[][] m) {
        for (int j=0; j<m[0].length; j++) {
            for (int i=0; i<m.length-1; i++) {
                for (int k=i+1; k<m.length; k++) {
                    if (simili(m[i][j], m[k][j])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    public static void main(String[] args) {
        String[][] m = {
            {"ciao", "ciao", "culk", "palle"},
            {"novità", "bello", "brutto", "rosso"},
            {"ckola", "sk", "forse", "ciao"},
            {"ciola", "porce", "acqua", "okke"}
        };

        IO.println(simili(m));
    }
}
