//scrivere una funzione che verifica se l'array in input è simmetrico

package Lezione5;

import IO.*;
public class Esercizio9 {
    public static boolean isSimmetrico(int[] array) {
        for (int i=0; i<(array.length/2); i++) {
            if (array[i] != array[array.length-i-1]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] arraySimmetricoPari = {1, 2, 2, 1};
        int[] arraySimmetricoDispari = {1, 2, 3, 2, 1};
        int[] arrayAsimmetricoPari = {1, 2, 3, 1};
        int[] arrayAsimmetricoDispari = {1, 2, 3, 1, 5};

        IO.println(isSimmetrico(arraySimmetricoPari));
        IO.println(isSimmetrico(arraySimmetricoDispari));
        IO.println(isSimmetrico(arrayAsimmetricoPari));
        IO.println(isSimmetrico(arrayAsimmetricoDispari));
    }
}