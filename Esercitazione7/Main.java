package Esercitazione7;
import IO.*;
import java.util.*;
public class Main {
    /* eliminare da una LinkedList i numeri pari, sia in maniera iterativa che ricorsiva */
    public static void eliminaPariIt(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return;
        }

        for (Iterator<Integer> it = l.iterator(); it.hasNext();) {
            if (it.next() % 2 == 0) {
                it.remove();
            }
        }

        return;
    }



    public static void eliminaPariRic(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return;
        }

        eliminaPariRic(l.iterator());
    }

    private static void eliminaPariRic(Iterator<Integer> it) {
        if (!it.hasNext()) {
            return;
        }

        if (it.next() % 2 == 0) {
            it.remove();
        }

        eliminaPariRic(it);
    }



    /* data una LinkedList di interi, restituire una lista che contiene
     * tutti i numeri che sono la somma del precedente e
     * del successivo (utilizzando il ListIterator)
     */
    public static LinkedList<Integer> listaSomma(LinkedList<Integer> l) {
        LinkedList<Integer> res = new LinkedList<>();

        if (l == null || l.size() < 3) {
            return res;
        }

        ListIterator<Integer> it = l.listIterator();

        int prec = it.next();
        while (it.hasNext()) {
            int x = it.next();

            if (!it.hasNext()) {
                return res;
            }

            int succ = it.next();

            if ((prec + succ) == x) {
                res.add(x);
            }

            prec = x;
            it.previous();
        }

        return res;
    }




    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.addLast(1);
        lista.addLast(4);
        lista.addLast(3);
        lista.addLast(2);
        lista.addLast(-1);
        IO.println(lista);

        IO.println(listaSomma(lista));

        Iterator<Integer> it = lista.iterator();
        it.next();
        it.remove();    //rimuove l'ultimo elemento restituito da next

        IO.println(lista);


        eliminaPariRic(lista);
        IO.println(lista);
    }
}
