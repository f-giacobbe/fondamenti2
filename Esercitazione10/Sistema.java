package Esercitazione10;

import java.util.*;

public class Sistema {
    private LinkedList<Pilota> piloti;
    private LinkedList<Gara> gare;
    private LinkedList<Scuderia> scuderie;

    public Sistema(LinkedList<Pilota> piloti, LinkedList<Gara> gare, LinkedList<Scuderia> scuderie) {
        this.piloti = new LinkedList<>(piloti);
        this.gare = new LinkedList<>(gare);
        this.scuderie = new LinkedList<>(scuderie);
    }



    public boolean verificaCittaPilota(String c, String p) {
        for (Gara g : gare) {
            Iterator<String> itP = g.getPiloti().iterator();
            Iterator<String> itS = g.getScuderie().iterator();

            while (itP.hasNext()) {
                String pilota = itP.next();
                String scuderia = itS.next();

                if (pilota.equals(p) && cittaScuderia(scuderia, c))
                    return false;
            }
        }

        return true;
    }

    private boolean cittaScuderia(String scuderia, String c) {
        for (Scuderia s : scuderie) {
            if (scuderia.equals(s.getNome()) && c.equals(s.getCitta()))
                return true;
        }

        return false;
    }



    public int numeroPiloti(String c1, String c2) {
        LinkedList<String> nomiPiloti = new LinkedList<>();

        for (Gara g : gare) {
            if (g.getLuogo().equals(c1)) {

                Iterator<String> it1 = g.getPiloti().iterator();
                Iterator<String> it2 = g.getScuderie().iterator();

                while (it1.hasNext()) {
                    String pilota = it1.next();
                    String scuderia = it2.next();

                    if (!nomiPiloti.contains(pilota) && cittaScuderia(scuderia, c2))
                        nomiPiloti.add(pilota);
                }
            }
        }

        return nomiPiloti.size();
    }



    public float compensoTotaleScuderia(String s) {
        float res = 0;

        float extra = 0;
        for (Scuderia scuderia : scuderie) {
            if (scuderia.getNome().equals(s)) {
                extra = scuderia.getCompensoExtra();
                break;
            }
        }

        for (Gara g : gare) {
            ListIterator<String> it1 = g.getPiloti().listIterator();
            ListIterator<String> it2 = g.getScuderie().listIterator();

            while (it1.hasNext()) {
                String pilota = it1.next();
                String scuderia = it2.next();
                boolean primoPosto = it1.previousIndex() == 0;

                if (scuderia.equals(s)) {
                    for (Pilota p : piloti) {
                        if (p.getNome().equals(pilota)) {
                            res += p.getCompensoPerGara();

                            if (primoPosto) {
                                res += extra;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}
