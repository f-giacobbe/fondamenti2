package Lezione4;

import IO.*;
public class Array_dinamico {
    public static void main(String[] args) {
        int[] a = new int[IO.readInt("Digita dimensione array: ")];

        for (int i=0; i<a.length; i++) {
            a[i] = IO.readInt("Dammi un numero intero: ");
        }

        for (int i=0; i<a.length; i++) {
            IO.print(a[i] + ";");
        }

        //per accedere alla dimensione dell'array
        IO.println(a.length);
    }
}
