package Lezione19;

import IO.*;
import java.util.*;

public class Main {
    /* verificare se la somma dei numeri pari in una LinkedList<Integer> è uguale alla somma dei numeri
     * dispari
     */
    public static boolean sommeUguali(LinkedList<Integer> l) {
        if (l == null) {
            return true;
        }

        return sommeUguali(l.iterator(), 0, 0);
    }

    private static boolean sommeUguali(Iterator<Integer> it, int sPari, int sDispari) {
        if (!it.hasNext()) {
            return sPari == sDispari;
        }

        int el = it.next();

        if (el % 2 == 0) {
            return sommeUguali(it, sPari + el, sDispari);
        }

        return sommeUguali(it, sPari, sDispari + el);
    }



    public static int verifica(LinkedList<Integer> l) {
        if (l == null) {
            throw new RuntimeException();
        }

        return verifica(l.iterator(), null);
    }

    private static int verifica(Iterator<Integer> it, Integer min) {
        if (!it.hasNext()) {
            return min;
        }

        int el = it.next();

        if (min == null) {
            min = el;
        }

        return verifica(it, el<min ? el : min);
    }



    public static void main(String[] args) {
        int[] a = {1, 0, 4, 3};
        ListaConcatenataInt l = new ListaConcatenataInt(a);

        IO.println(l.sommeUguali());


        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(0);
        ll.add(3);
        ll.add(4);

        IO.println(sommeUguali(ll));
        MergeSort.mergeSort(a);
        IO.println(Arrays.toString(a));
        IO.println(verifica(ll));
    }
}
