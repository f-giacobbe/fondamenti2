/* sommatoria dei primi n numeri interi (ricorsiva), visualizzando i record di attivazione (disegno) */

package Lezione8;

import IO.*;
public class Esercizio15 {
    public static int SommaPrimiN(int n) {
        if (n==0) {
            return 0;
        }

        return n + SommaPrimiN(n-1);
    }



    public static void main(String[] args) {
        IO.println(SommaPrimiN(6));
    }
}
