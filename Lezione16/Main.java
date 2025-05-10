package Lezione16;
import IO.*;
import Lezione16.listeconcatenate.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Integer[] a = new Integer[4];
        a[0] = 4;
        a[1] = 1;
        a[2] = 3;
        a[3] = 5;

        Coppia<Integer> minimoMassimoInt = Coppia.minMax(a);
        IO.println(minimoMassimoInt);


        String[] as = {"C", "A", "F"};
        Coppia<String> minimoMassimoStr = Coppia.minMax(as);
        IO.println(minimoMassimoStr);


        ListaConcatenata<Integer> l = new ListaConcatenata<>();
        l.aggiungiInCoda(1);
        l.aggiungiInCoda(2);
        l.aggiungiInCoda(3);
        IO.println(l);

        l.modificaInPosizione(100, 1);
        IO.println(l);

        IO.println(Arrays.toString(l.restituisciArray()));



        ListaConcatenataInt ex = new ListaConcatenataInt();
        ex.aggiungiInCoda(6);
        ex.aggiungiInCoda(7);
        ex.aggiungiInCoda(6);
        ex.aggiungiInCoda(2);
        ex.aggiungiInCoda(1);
        ex.aggiungiInCoda(9);
        ex.aggiungiInCoda(9);
        ex.aggiungiInCoda(9);
        IO.println(ex.verifica(2,5));
    }
}
