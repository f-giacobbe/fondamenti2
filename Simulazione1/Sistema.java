package Simulazione1;

import IO.*;
import java.util.LinkedList;

public class Sistema {
    private LinkedList<Viaggio> listaViaggi;
    private LinkedList<Conducente> listaConducenti;

    public Sistema() {
        this.listaViaggi = null;
        this.listaConducenti = null;
    }

    public Sistema(LinkedList<Viaggio> listaViaggi, LinkedList<Conducente> listaConducenti) {
        this.listaViaggi = new LinkedList<>(listaViaggi);
        this.listaConducenti = new LinkedList<>(listaConducenti);
    }



    public boolean verifica(int numMax, String nomeConducente) {
        if (nomeConducente == null)
            return false;

        for (String d : this.listaDestinazioni()) {
            int viaggiFattiDaConducente = 0;

            for (Viaggio v : listaViaggi) {
                if (v.getDestinazione().equals(d)) {
                    for (Conducente c : listaConducenti) {
                        if (c.getNome().equals(nomeConducente) && c.getViaggi().contains(v.getCodice())) {
                            viaggiFattiDaConducente++;
                            break;
                        }
                    }
                }
            }

            if (viaggiFattiDaConducente > numMax)
                return false;
        }

        return true;
    }

    private LinkedList<String> listaDestinazioni() {
        LinkedList<String> res = new LinkedList<>();

        for (Viaggio v : listaViaggi)
            if (!res.contains(v.getDestinazione()))
                res.add(v.getDestinazione());
        
        return res;
    }



    public LinkedList<String> conducentiSovraccarichi() {
        LinkedList<String> res = new LinkedList<>();
        float limite = mediaViaggi() * 2;

        for (Conducente c : listaConducenti)
            if (c.getViaggi().size() >= limite)
                res.add(c.getNome());

        return res;
    }

    private float mediaViaggi() {
        int sommaViaggi = 0;
        int nConducenti = listaConducenti.size();

        for (Conducente c : listaConducenti)
            sommaViaggi += c.getViaggi().size();

        return (float)sommaViaggi/nConducenti;
    }



    public LinkedList<String> stesseCaratteristiche(String nomeConducente) {
        LinkedList<String> res = new LinkedList<>();

        if (nomeConducente == null)
            return res;

        Conducente oggettoConducente = null;
        for (Conducente c : listaConducenti) {
            if (c.getNome().equals(nomeConducente)) {
                oggettoConducente = c;
                break;
            }
        }

        int durataTarget = durataComplessiva(oggettoConducente);
        int numPaxTarget = numPaxComplessivi(oggettoConducente);

        for (Conducente c : listaConducenti) {
            if (!c.getNome().equals(nomeConducente) && durataComplessiva(c) == durataTarget && numPaxComplessivi(c) == numPaxTarget)
                res.add(c.getNome());
        }

        return res;
    }

    private int durataComplessiva(Conducente c) {
        int res = 0;

        for (Viaggio v : listaViaggi) {
            if (c.getViaggi().contains(v.getCodice()))
                res += v.getDurata();
        }

        return res;
    }

    private int numPaxComplessivi(Conducente c) {
        int res = 0;

        for (Viaggio v : listaViaggi) {
            if (c.getViaggi().contains(v.getCodice()))
                res += v.getNumPasseggeri();
        }

        return res;
    }





    public static void main(String[] args) {
        LinkedList<Viaggio> listaViaggi = new LinkedList<>();
        Viaggio v1 = new Viaggio("V1", "Roma", 2, 5);
        Viaggio v2 = new Viaggio("V2", "Roma", 8, 20);
        Viaggio v3 = new Viaggio("V3", "Salerno", 2, 5);
        Viaggio v4 = new Viaggio("V4", "Salerno", 4, 70);
        Viaggio v5 = new Viaggio("V5", "Reggio Calabria", 3, 5);
        Viaggio v6 = new Viaggio("V6", "Roma", 1, 5);
        listaViaggi.add(v1);
        listaViaggi.add(v2);
        listaViaggi.add(v3);
        listaViaggi.add(v4);
        listaViaggi.add(v5);
        listaViaggi.add(v6);


        LinkedList<Conducente> listaConducenti = new LinkedList<>();

        LinkedList<String> s1 = new LinkedList<>();
        s1.add("V1");
        s1.add("V3");
        s1.add("V5");
        s1.add("V6");
        Conducente c1 = new Conducente("Rossi", s1);

        LinkedList<String> s2 = new LinkedList<>();
        s2.add("V2");
        Conducente c2 = new Conducente("Bianchi", s2);

        LinkedList<String> s3 = new LinkedList<>();
        s3.add("V4");
        Conducente c3 = new Conducente("Verdi", s3);

        listaConducenti.add(c1);
        listaConducenti.add(c2);
        listaConducenti.add(c3);

        Sistema s = new Sistema(listaViaggi, listaConducenti);


        IO.println(s.verifica(1, "Rossi"));
        IO.println(s.conducentiSovraccarichi());
        IO.println(s.stesseCaratteristiche("Bianchi"));
    }
}
