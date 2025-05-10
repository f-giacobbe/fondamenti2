package Lezione21;
import IO.*;
import java.util.*;
public class Main {
    public static boolean verifica(LinkedList<Integer> l) {
        if (l == null)
            return false;
        
        if (l.size() <= 1)
            return true;

        ListIterator<Integer> it = l.listIterator();    

        return verifica(it, it.next());
    }

    private static boolean verifica(ListIterator<Integer> it, int somma) {
        if (!it.hasNext())
            return true;

        int curr = it.next();

        if (curr <= ((float)somma)/(it.nextIndex()-1))
            return false;

        return verifica(it, somma+curr);
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        ListaConcatenataInt l = new ListaConcatenataInt(a);

        IO.println(l.verifica());



        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(3);
        ll.add(2);
        ll.add(4);
        IO.println(verifica(ll));
    }
}
