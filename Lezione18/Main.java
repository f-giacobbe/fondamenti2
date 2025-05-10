package Lezione18;

import java.util.*;
public class Main {
    /* metodo che verifica se una LinkedList di interi è palindroma */
    public static boolean isPalindromeIt(LinkedList<Integer> l) {
        if (l == null || l.size() <= 1) {
            return true;
        }

        ListIterator<Integer> sx = l.listIterator();
        ListIterator<Integer> dx = l.listIterator(l.size());
        /* se nel ListIterator mettiamo tra le parentesi un valore, partirà da quel punto.
         * In questo caso, dovendo partire dalla fine inseriamo come parametro la dimensione
         */

        /* SOLO PER LISTITERATOR - possiamo verificare gli indici con nextIndex() e previousIndex() */
        while (sx.nextIndex() < dx.previousIndex()) {
            if (!(sx.next().equals(dx.previous()))) {
                return false;
            }
        }

        return true;
    }



    public static boolean isPalindromeRic(LinkedList<Integer> l) {
        if (l == null || l.size() <= 1) {
            return true;
        }

        return isPalindromeRic(l.listIterator(), l.listIterator(l.size()));
    }

    private static boolean isPalindromeRic(ListIterator<Integer> sx, ListIterator<Integer> dx) {
        if (sx.nextIndex() >= dx.previousIndex()) {
            return true;
        }

        if (!(sx.next().equals(dx.previous()))) {
            return false;
        }

        return isPalindromeRic(sx, dx);
    }



    /* metodo che verifica se una lista è l'inversa dell'altra */
    public static boolean isInverseIt(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        if (l1 == null || l2 == null || l1.size() != l2.size()) {
            return false;
        }

        ListIterator<Integer> it1 = l1.listIterator();
        ListIterator<Integer> it2 = l2.listIterator(l2.size());

        while (it1.hasNext()) {
            if (!(it1.next().equals(it2.previous()))) {
                return false;
            }
        }

        return true;
    }



    public static boolean isInverseRic(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        if (l1 == null || l2 == null || l1.size() != l2.size()) {
            return false;
        }

        return isInverseRic(l1.listIterator(), l2.listIterator(l2.size()));
    }

    private static boolean isInverseRic(ListIterator<Integer> it1, ListIterator<Integer> it2) {
        if (!(it1.hasNext())) {
            return true;
        }

        if (!(it1.next().equals(it2.previous()))) {
            return false;
        }

        return isInverseRic(it1, it2);
    }
}
