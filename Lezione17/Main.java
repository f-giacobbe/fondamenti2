package Lezione17;
import IO.*;
import java.util.*;
public class Main {
    /* inefficiente in quanto quadratico (il metodo get scandisce ogni volta tutta la lista fino alla pos.) */
    public static Integer massimoInefficiente(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return null;
        }

        Integer max = l.getFirst();
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) > max) {
                max = l.get(i);
            }
        }

        return max;
    }



    /* metodo che utilizza l'ITERATORE, in modo da scandirci noi la lista */
    public static Integer massimoEfficienteWhile(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return null;
        }

        Integer max = l.getFirst();

        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            Integer curr = it.next();

            if (curr.compareTo(max) > 0) {
                max = curr;
            }
        }

        return max;
    }


    public static Integer massimoEfficienteFor(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return null;
        }

        Integer max = l.getFirst();

        for (Iterator<Integer> it = l.iterator(); it.hasNext();) {
            Integer curr = it.next();

            if (curr.compareTo(max) > 0) {
                max = curr;
            }
        }

        return max;
    }



    public static int valoriPari(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return 0;
        }

        int res = 0;

        for (Iterator<Integer> it = l.iterator(); it.hasNext();) {
            Integer curr = it.next();

            if (curr % 2 == 0) {
                res++;
            }
        }

        return res;
    }



    public static LinkedList<Integer> listaPari(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return null;
        }

        LinkedList<Integer> res = new LinkedList<>();

        for (Iterator<Integer> it = l.iterator(); it.hasNext();) {
            Integer curr = it.next();

            if (curr % 2 == 0) {
                res.add(curr);
            }
        }

        return res;
    }



    public static LinkedList<Float> listaMedie(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return null;
        }

        LinkedList<Float> res = new LinkedList<>();

        if (l.size() == 1) {
            res.add(l.getFirst().floatValue());
            return res;
        }

        Iterator<Integer> it = l.iterator();
        Integer lastVal = it.next();
        while (it.hasNext()) {
            Integer curr = it.next();

            res.add((lastVal + curr)/2f);

            lastVal = curr;
        }

        return res;
    }



    public static int sommaRicorsiva(LinkedList<Integer> l) {
        if (l == null || l.size() == 0) {
            return 0;
        }

        return sommaRicorsiva(l.iterator(), 0);
    }


    private static int sommaRicorsiva(Iterator<Integer> it, int somma) {
        if (!it.hasNext()) {
            return somma;
        }

        return sommaRicorsiva(it, somma += it.next());
    }



    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.addFirst(1);
        l.add(2);
        l.add(2, 3);
        IO.println(l);
        
        LinkedList<Integer> copia = new LinkedList<>(l);
        /* copia profonda di struttura, ma non profondissima */

        l.removeFirst();
        l.removeLast();
        IO.println(l);
        IO.println("Copia: " + copia);



        //copia non profondissima, ecco perché
        Persona p1 = new Persona("A", "A", 10, null, null);
        Persona p2 = new Persona("B", "B", 10, null, null);
        LinkedList<Persona> lp = new LinkedList<>();
        lp.add(p1);
        lp.add(p2);

        LinkedList<Persona> lpCopia = new LinkedList<>(lp);
        lp.removeFirst();   //le strutture sono separate 
        lp.get(0).setCognome("Z");  //ma le info dei nodi potrebbero non esserlo
        IO.println(lp);
        IO.println(lpCopia);




        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        IO.println("la lista " + lista + " contiene " + valoriPari(lista) + " numeri pari");//es1
        IO.println("la linked-list formata dai soli elementi pari è " + listaPari(lista));//es2
        IO.println(listaMedie(lista));//es3
        IO.println(sommaRicorsiva(lista));//es4
    }
}
