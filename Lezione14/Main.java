package Lezione14;
import IO.*;
import Lezione14.listeconcatenate.*;
public class Main {
    public static void main(String[] args) {
        ListaConcatenataInt l = new ListaConcatenataInt();
        IO.println("Lista vuota: " + l);

        l.aggiungiInCoda(0);
        l.aggiungiInCoda(1);
        l.aggiungiInCoda(2);
        l.aggiungiInCoda(3);
        IO.println("La lista ha ora lunghezza " + l.getLunghezza());
        IO.println(l);

        l.aggiungiInTesta(-1);
        IO.println(l);
        IO.println("La lista ha lunghezza: " + l.getLunghezza());

        l.rimuoviCoda();
        IO.println(l);

        l.modificaInPosizione(100, 3);
        IO.println(l);

        l.rimuoviPosizione(2);
        IO.println(l);

        int[] a = {1, 2, 3, 4, 5};
        int[] a2 = null;
        int[] a3 = {};

        ListaConcatenataInt la = new ListaConcatenataInt(a);
        ListaConcatenataInt la2 = new ListaConcatenataInt(a2);
        ListaConcatenataInt la3 = new ListaConcatenataInt(a3);

        IO.println("Lunghezza: " + la.getLunghezza() + " Lista: " + la);
        IO.println("Lunghezza: " + la2.getLunghezza() + " Lista: " + la2);
        IO.println("Lunghezza: " + la3.getLunghezza() + " Lista: " + la3);
    }
}
