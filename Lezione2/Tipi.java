package Lezione2;
/* questo è un commento */

// questo è un commento di una singola riga

import IO.*;

public class Tipi {
    public static void main(String[] args) {
        IO.println("Ciao");
        
        int a = 5;
        int b = IO.readInt("Digita un numero: ");

        int c = a+b;
        IO.println("La somma di " + a + " e " + b + " è: " + c);
        /* la variabile c è necessaria in quanto se avessi sommato a e b all'interno della stringa
         * allora li avrei solo concatenati +a+b+
         * 
         * per farlo senza variabile avrei dovuto scrivere +(a+b)
         */

        
        /* IMPORTANTE
         * quando scriviamo un numero decimale nel codice, va scritto col PUNTO .
         * ma quando lo diamo in input all'esecuzione nel terminale, allora va scritto con la VIRGOLA ,
         */




        //assegniamo un float a una variabile
        float d = 5.13f;
        IO.println(d);
        //è importante la "f" in quanto di default java lo interpreta come double (64-bit)
        
        //è bene specificare con la "d" anche quando definiamo una costante di tipo double


        // da non fare in quanto rischioso, convertendo vado a perdere precisione, soprattutto per le grandi cifre
        int n = 100;
        float m = n;
        IO.println(m);
        /* posso assegnare a una variabile float un intero nonostante la differenza di come vengono
         * rappresentati (la loro codifica è completamente diversa), in quanto java fa una CONVERSIONE
         * 
         * esempio: 316,66 viene rappresentato come 3,1666 * 10^2
         *          in binario 110,001 -> 1,10001 x 10^10 (il 10 sarebbe 2 in binario), la parte dopo la
         * virgola (10001) si chiama mantissa
         */


        float x = 100.0f;
        int y = (int)x;
        IO.println(y);
        /* il contrario invece NON è possibile in quanto sono entrambi tipi di 32-bit ma mentre
         * il numero massimo rappresentato da un intero è 2^31, mentre quello massimo rappresentato
         * da un float è 2^128
         * 
         * qui, per esempio, funziona in quanto ho FORZATO IL CASTING attraverso (int), ma se provo
         * a forzare il casting di un float superiore a 2^31, l'int sarà esattamente del limite 2^31
         */
        float numerogrande = 4000000000.0f;
        int intnumerogrande = (int)numerogrande;
        IO.print(intnumerogrande);
    }
}