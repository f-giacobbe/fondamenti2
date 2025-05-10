package Esercitazione10;

import java.util.LinkedList;

public class Gara {
    private String id;
    private String luogo;
    private LinkedList<String> piloti;
    private LinkedList<String> scuderie;

    public Gara(String id, String luogo, LinkedList<String> piloti, LinkedList<String> scuderie) {
        this.id = id;
        this.luogo = luogo;
        this.piloti = new LinkedList<>(piloti);
        this.scuderie = new LinkedList<>(scuderie);
    }

    public String getId() {
        return id;
    }
    public String getLuogo() {
        return luogo;
    }
    public LinkedList<String> getPiloti() {
        return new LinkedList<>(this.piloti);
    }
    public LinkedList<String> getScuderie() {
        return new LinkedList<>(this.scuderie);
    }

    @Override
    public String toString() {
        return "Gara [id=" + id + ", luogo=" + luogo + ", piloti=" + piloti + ", scuderie=" + scuderie + "]";
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Gara))
            return false;

        Gara g2 = (Gara)o;

        if (this.id.equals(g2.id) && this.luogo.equals(g2.luogo) && this.piloti.equals(g2.piloti)
        && this.scuderie.equals(g2.scuderie))
            return true;

        return false;
    }
}
