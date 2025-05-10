package Lezione15;
import Lezione15.listeconcatenate.*;
import IO.*;
public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 3};
        int[] c = {1, 1, 2, 3, 0, 0, 0, 5, 5};
        ListaConcatenataInt l = new ListaConcatenataInt(a);
        ListaConcatenataInt l2 = new ListaConcatenataInt(b);
        ListaConcatenataInt l3 = new ListaConcatenataInt(c);
        ListaConcatenataInt l4 = null;

        IO.println("Somma ricorsiva: " + l.sommaElementi());
        IO.println("Somma ricorsiva 2: " + l.sommaElementi2());
        IO.println("Somma ricorsiva 3: " + l.sommaElementi3());
        IO.println("Somma ricorsiva 4: " + l.sommaElementi4());


        //esercizi per casa
        IO.println(l.eOrdinataCrescenteIt());
        IO.println(l2.eOrdinataCrescenteIt());
        IO.println("");

        IO.println(l.eOrdinataCrescenteRic());
        IO.println(l2.eOrdinataCrescenteRic());
        IO.println("");

        IO.println(l.sottoSequenzaPariIt());
        IO.println(l.sottoSequenzaPariRic());
        IO.println("");

        l3.modificaRic();
        IO.println(l3);

        IO.println(l.equals(l4));
    }
}
