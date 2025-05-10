package Lezione20;

import IO.*;
import java.util.*;

public class Main {
    public static int numeroSottoseqOrdinate(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return 0;
        }

        if (l.size() <= 2) {
            return 1;
        }

        ListIterator<Integer> it = l.listIterator();
        int first = it.next();
        boolean crescente = first <= it.next();

        return numeroSottoseqOrdinate(it, crescente);
    }

    private static int numeroSottoseqOrdinate(ListIterator<Integer> it, boolean crescente) {
        if (!it.hasNext()) {
            return 1;
        }

        int curr = it.previous();
        it.next();
        int succ = it.next();

        if ((crescente && curr <= succ) || (!crescente && curr >= succ)) {
            return numeroSottoseqOrdinate(it, crescente);
        }

        return 1 + numeroSottoseqOrdinate(it, !crescente);
    }



    public static void main(String[] args) {
        int[] a = {1, 3, 2, 1, 0, 4};
        ListaConcatenataInt l = new ListaConcatenataInt(a); //3

        IO.println(l.numeroSottoseqOrdinate());
        IO.println(l.numeroSottoseqOrdinateProf());


        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.add(0);
        ll.add(4);

        IO.println(numeroSottoseqOrdinate(ll));

        QuickSort.quickSort(a);
        IO.println(Arrays.toString(a));
    }
}
