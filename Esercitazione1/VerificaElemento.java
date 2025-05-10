//verificare se un array contiene un elemento specifico
package Esercitazione1;

import IO.*;
public class VerificaElemento {
    public static boolean verifica(int[] array, int x) {
        for (int i=0; i<array.length; i++) {
            if (array[i] == x) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        IO.println(verifica(a, 1));
        IO.println(verifica(a, 4));
    }
}
