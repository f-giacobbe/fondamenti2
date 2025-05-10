package Lezione4;

import IO.*;
public class Array {
    public static void main(String[] args) {
        int[] a = new int[5];

        for (int i=0; i<5; i++) {
            a[i] = IO.readInt("Dammi un numero intero: ");
        }

        for (int i=0; i<5; i++) {
            IO.print(a[i] + ";");
        }

        //per accedere alla dimensione dell'array
        IO.println(a.length);
    }
}
