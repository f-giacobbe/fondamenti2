package Lezione16;
import IO.*;
public class WrapperClass {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        /* creo una coppia di stringhe - Java sostituisce T con String */
        Coppia<String> cs = new Coppia<>();
        cs.setElem1("Primo elemento");
        cs.setElem2("Secondo elemento");
        IO.println(cs);

        
        /* per creare una coppia di interi, però, NON POSSO FARE Coppia<int>, in quanto T deve essere una
         * classe, non un tipo di base
         * 
         * Possiamo rimediare utilizzando la classe di default di java Integer, che ha le medesime
         * caratteristiche (WRAPPER CLASS), che sono IMMUTABILI
         */
        int a = 56;
        Integer b = 45;
        @SuppressWarnings("removal")
        Integer c = new Integer(10);    //sbarrato perché inusuale

        Coppia<Integer> ci = new Coppia<>();

        
        //attenzione
        Integer d = 32;
        Integer e = 64;
        Integer f = d + e;  //la somma funziona
        IO.println("somma: " + d + e + f);      //ma attenzione alla concatenazione
        IO.println("somma: " + (d + e + f));      //così fa la somma all'interno della stringa
        /* Java, per fare la somma, trasforma l'oggetto Integer in un tipo di base */

        int d1 = d.intValue();  //intValue restituisce l'int rispettivo (è ciò che fa durante la somma)


        //comparazione - NON USARE == in quanto poco affidabile
        Integer x1 = 32;
        Integer x2 = 32;    //numero piccolo - funziona
        if (x1 == x2) {
            IO.println("Numeri uguali");
        }
        else {
            IO.println("Numeri diversi");
        }

        Integer y1 = 320;
        Integer y2 = 320;   //numero grande - non funziona
        if (y1 == y2) {
            IO.println("Numeri uguali");
        }
        else {
            IO.println("Numeri diversi");
        }
        /* Questo perché la jvm, in numeri in genere <100, va ad allocare allo stesso indirizzo
         * Questo perché gli Integer sono tipi immutabili
         */


        //per cui usare l'EQUALS
        Integer z1 = 320;
        Integer z2 = 320;   //numero grande - non funziona
        if (z1.equals(z2)) {
            IO.println("Numeri uguali");
        }
        else {
            IO.println("Numeri diversi");
        }



        //METODI STATICI CLASSE INTEGER
        IO.println(Integer.MIN_VALUE);
        IO.println(Integer.MAX_VALUE);
            //utili per inizializzare le variabili



        //comparazione - confronta i valori rispettivi
        Integer h = 50;
        Integer j = 90;
        if (h > j) {
            IO.println("a è maggiore di b");
        }
        else {
            IO.println("a è minore o uguale di b");
        }
        //è tuttavia preferibile utilizzare la funzione compareTo (1 se il primo è maggiore, -1 se minore)
        if (h.compareTo(j) > 0) {
            IO.println("a è maggiore di b");
        }
        else {
            IO.println("a è minore o uguale di b");
        }
    }
}
