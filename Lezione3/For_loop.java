package Lezione3;

import IO.*;
public class For_loop {
    public static void main(String[] args) {
        //scrittura di un qualcosa 10 volte (iterativo)

        /*il primo parametro è la VARIABILE, il secondo la CONDIZIONE affinché il loop continui, il terzo
        /l'INCREMENTO dopo ogni iterazione (++ aumenta di 1 -> i=i+1)
        /(chiaramente la variabile i è LOCALE al ciclo for: una volta terminato muore) */
        for (int i=0; i<10; i++)
            IO.println(i + ": Ciao"); //in questo caso printo anche la variabile i corrente

        /* dopo che viene eseguito il comando println, viene prima incrementato il valore di i (i++),
         * in secondo luogo viene verificata la condizione che, se ancora vale, ripete l'iterazione
         */




        //non mettendo le parentesi graffe, viene eseguita solo una linea di codice
        //così ne eseguo più
        for (int i=0; i<5; i++) {
            IO.println("Ciao");
            IO.println("Come stai?");
        }
        //è dunque sempre meglio utilizzare le parentesi graffe per definire il blocco del for




        /*dichiarando i prima del for, diviene una variabile universale ed è dunque possibile richiamarla,
         * ad esempio utilizzando il suo ultimo valore assunto, fuori dal ciclo for
         */
        int i;
        for (i=0; i<3; i++) {
            IO.println("Ciao");
        }
        IO.println("L'ultimo valore assunto da i è " + i);



        //si può anche
        int j=0;
        for (; j<3; j++) {
            IO.println("Hello");
        }
    }
}
