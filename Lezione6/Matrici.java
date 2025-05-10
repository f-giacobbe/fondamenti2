package Lezione6;

import IO.*;
public class Matrici {

    //riempimento matrice da input
    public static void leggiMatrice(int[][] arg) {
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[0].length; j++) {
                arg[i][j] = IO.readInt("Digita valore riga " + i + " colonna " + j + ": ");
            }
        }
    }


    
    //stampa matrice
    public static void stampaMatrice(int[][] arg) {
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[0].length; j++) {
                IO.print(arg[i][j] + " ");
            }
            IO.println();   //per separare le righe
        }
    }



    //metodo che crea matrice
    public static int[][] creaMatrice(int a, int b) {
        int[][] m = new int[a][b];
        leggiMatrice(m);

        return m;
    }



    public static void main(String[] args) {
        //MATRICE 2x3
        int[][] a = new int[2][3];

        //Negli array, gli spazi numerici vengono inizializzati a 0 (a differenza delle variabili singole)
        IO.println(a[0][0]);
        /* ciò avviene perché la variabile singola è allocata nello stack, mentre gli array rimandano
         * all'heap, dove le sue celle assumono il valore iniziale di 0 (grazie a NEW, altrimenti no)
         */


        leggiMatrice(a);
        stampaMatrice(a);


        stampaMatrice(creaMatrice(3, 3));
    }
}
