package Lezione2;
import IO.*;
public class Media {
    public static void main(String[] args) {
        int a = 5;
        int b = IO.readInt("Digita numero: ");

        //devo creare una variabile di tipo float
        float media = (a+b)/2;

        IO.println("La media è " + media);
        /* ma così è SBAGLIATO, in quanto anche le operazioni in java sono tipizzate:
         * facendo un rapporto tra interi, viene restituito un intero
         * 
         * posso risolverlo facendo il rapporto tra int e float, in quanto l'output è del tipo più grande
         * tra i due
         */

        float media2 = (a+b)/2.0f;
        IO.println("La media corretta è: " + media2);

        //oppure

        float media3 = ((float)(a+b))/2;
        IO.println(media3);
    }
}
