package Esercitazione9;

import java.util.*;

@SuppressWarnings("unused")
public class Sistema {
    private LinkedList<Opera> opere;
    private LinkedList<Vendita> vendite;

    public Sistema(LinkedList<Opera> opere, LinkedList<Vendita> vendite) {
        this.opere = new LinkedList<>(opere);
        this.vendite = new LinkedList<>(vendite);
    }

    public boolean consistente(int maxOfferteIndividuali) {
        for (Vendita v : vendite) {
            if (v.getOfferte().size() != v.getOfferenti().size())
                return false;

            Iterator<Integer> it = v.getOfferte().listIterator();
            if (it.hasNext()) {
                int offPrec = it.next();
                while (it.hasNext()) {
                    int off = it.next();

                    if (offPrec >= off)
                        return false;

                    offPrec = off;
                }
            }

            Iterator<String> it2 = v.getOfferenti().listIterator();
            if (it2.hasNext()) {
                String nomeP = it2.next();
                while (it2.hasNext()) {
                    String nome = it2.next();

                    if (nomeP.equals(nome))
                        return false;

                    nomeP = nome;
                }
            }

            LinkedList<String> checked = new LinkedList<>();
            for (String nome : v.getOfferenti()) {
                if (!(checked.contains(nome))){
                    if (numeroOfferte(nome, v.getOfferenti()) > maxOfferteIndividuali)
                        return false;

                    checked.add(nome);
                }
            }
        }

        return true;
    }

    private static int numeroOfferte(String nome, LinkedList<String> offerenti) {
        int c = 0;

        for (String n : offerenti)
            if (n.equals(nome))
                c++;
        
        return c;
    }



    public LinkedList<String> acquirentiSimili(String nomeAcquirente) {
        LinkedList<String> res = new LinkedList<>();

        if (nomeAcquirente == null)
            return res;

        LinkedList<String> autori = new LinkedList<>();
        for (Vendita v : vendite) {
            if (v.getOfferenti().getLast().equals(nomeAcquirente)) {
                for (Opera o : opere) {
                    if (o.getNome().equals(v.getOpera()) && !(autori.contains(o.getAutore()))) {
                        autori.add(o.getAutore());
                        break;
                    }
                }
            }
        }

        for (Vendita v : vendite) {
            String acquirente = v.getOfferenti().getLast();

            if (res.contains(acquirente) || acquirente.equals(nomeAcquirente))
                continue;

            for (Opera o : opere)
                if (o.getNome().equals(v.getOpera()) && autori.contains(o.getAutore()))
                    res.add(acquirente);
                    break;
        }

        return res;
    }



    public int maxRilancio(String autore) {
        int rilancioMax = 0;

        for (Opera o : opere) {
            if (o.getAutore().equals(autore)) {
                for (Vendita v : vendite) {
                    if (o.getNome().equals(v.getOpera())) {

                        Iterator<Integer> it = v.getOfferte().iterator();
                        if (it.hasNext()) {
                            int offPrec = it.next();
                            
                            while (it.hasNext()) {
                                int off = it.next();

                                if ((off-offPrec) > rilancioMax)
                                    rilancioMax = off-offPrec;

                                offPrec = off;
                            }
                        }
                    }
                }
            }
        }

        return rilancioMax;
    }
}
