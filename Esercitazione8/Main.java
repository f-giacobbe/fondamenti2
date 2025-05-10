package Esercitazione8;
import Esercitazione8.listeconcatenate.*;
import IO.*;
public class Main {
    public static void main(String[] args) {
        ListaConcatenataIntDoppia l = new ListaConcatenataIntDoppia(new int[] {1, 2, 3});

        IO.println(l.stampaPrecedentePos(1));

        ListaConcatenataInt l1 = new ListaConcatenataInt();
        l1.aggiungiInCoda(8);
        l1.aggiungiInCoda(5);
        l1.aggiungiInCoda(5);
        l1.aggiungiInCoda(3);
        l1.aggiungiInCoda(6);
        l1.aggiungiInCoda(2);
        l1.aggiungiInCoda(7);
        l1.aggiungiInCoda(-4);
        l1.aggiungiInCoda(4);
        l1.aggiungiInCoda(5);
        
        IO.println(l1.contaCoppie(5));
    }
}
