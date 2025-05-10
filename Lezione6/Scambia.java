package Lezione6;

import IO.*;
public class Scambia {

    public static void scambia(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }


    public static void main(String[] args) {
        int a = IO.readInt("Digita il valore di a: ");
        int b = IO.readInt("Digita il valore di b: ");
        
        IO.println("a=" + a + "; b=" + b);

        scambia(a, b);

        IO.println("a=" + a + "; b=" + b);
        /* notiamo che apparentemente non viene effettuato alcuno scambio, in quanto lo scambio
         * viene effettuato dentro il record di attivazione della funzione (quindi tra le copie di a e b)
         * e una volta che la funzione termina, il record viene cancellato
         * 
         * In generale, vale che quando passiamo degli argomenti a un metodo, viene passato in copia.
         * Ciò non vale negli array, in quanto punta sempre alle celle dell'heap
         */
    }
}
