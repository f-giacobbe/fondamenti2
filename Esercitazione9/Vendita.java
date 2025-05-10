package Esercitazione9;

import java.util.*;

public class Vendita {
    private String id;
    private String opera;
    private LinkedList<Integer> offerte;
    private LinkedList<String> offerenti;

    
    public Vendita(String id, String opera, LinkedList<Integer> offerte, LinkedList<String> offerenti) {
        this.id = id;
        this.opera = opera;
        this.offerte = new LinkedList<>(offerte);
        this.offerenti = new LinkedList<>(offerenti);   //costruttore copia LinkedList
    }

    public String getId() {
        return id;
    }
    public String getOpera() {
        return opera;
    }
    public LinkedList<Integer> getOfferte() {
        return new LinkedList<>(offerte);
    }
    public LinkedList<String> getOfferenti() {
        return new LinkedList<>(offerenti);
    }
    @Override
    public String toString() {
        return "Vendita [id=" + id + ", opera=" + opera + ", offerte=" + offerte + ", offerenti=" + offerenti + "]";
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Vendita))
            return false;

        Vendita v2 = (Vendita) o;

        if (!(this.id.equals(v2.id) && this.opera.equals(v2.opera)))
            return false;


        //offerte
        if (this.offerte.size() != v2.offerte.size())
            return false;

        Iterator<Integer> it1 = this.offerte.iterator();
        Iterator<Integer> it2 = v2.offerte.iterator();
        
        while (it1.hasNext()) {
            if (it1.next() != it2.next())
                return false;
        }


        //offerenti
        if (this.offerenti.size() != v2.offerenti.size())
            return false;

        Iterator<String> it3 = this.offerenti.iterator();
        Iterator<String> it4 = v2.offerenti.iterator();

        while (it3.hasNext()) {
            if (!(it3.next().equals(it4.next())))
                return false;
        }
        
        return true;
    }
}
