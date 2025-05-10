/* scrivere una funzione ricorsiva che calcola, dati due numeri interi m ed n, la potenza m^n */

package Esercitazione3;

import IO.*;
public class Potenza {
    public static int potenza(int m, int n) {
        if (n == 1) {
            return m;
        }
        else if (n == 0) {
            return 1;
        }

        return m * potenza(m, n-1);
    }



    public static void main(String[] args) {
        IO.println(potenza(2, 6));
    }
}
