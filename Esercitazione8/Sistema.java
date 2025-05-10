package Esercitazione8;
import java.util.*;
import IO.*;
@SuppressWarnings("unused")
public class Sistema {
    private LinkedList<Appartamento> appartamenti;
    private LinkedList<Impianto> impianti;



    public Sistema(LinkedList<Appartamento> appartamenti, LinkedList<Impianto> impianti) {
        this.appartamenti = new LinkedList<>();
        this.impianti = new LinkedList<>();

        for (Impianto im : impianti) {
            this.impianti.add(im);
        }

        for (Appartamento a : appartamenti) {
            this.appartamenti.add(a);
        }
    }



    public LinkedList<String> scaleUnicoTipo() {
        LinkedList<String> res = new LinkedList<>();

        //creo lista di scale distinte
        LinkedList<String> scale = this.getScale();

        for (String s : scale) {    //usa l'iteratore
            if (almenoUno(s) && stessoTipo(s)) {
                res.add(s);
            }
        }

        return res;
    }

    private LinkedList<String> getScale() {
        LinkedList<String> res = new LinkedList<>();

        for (Appartamento a : appartamenti) {
            if (!res.contains(a.getScala())) {
                res.add(a.getScala());
            }
        }

        return res;
    }

    private boolean almenoUno(String s) {
        for (Impianto i : this.impianti) {
            for (Appartamento a : this.appartamenti) {
                if (a.getCodice().equals(i.getAppartamento()) && a.getScala().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean stessoTipo(String s) {
        String tipo = null;

        for (Impianto i : this.impianti) {
            for (Appartamento a : this.appartamenti) {
                if (i.getAppartamento().equals(a.getCodice()) && a.getScala().equals(s)) {
                    if (tipo == null) {
                        tipo = i.getTipo();
                    }
                    else if (!i.getTipo().equals(tipo)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }



    public String tecnicoMax() {
        String res = "";
        int importoMax = 0;

        LinkedList<String> tecnici = getTecnici();
        for (String t : tecnici) {
            int incasso = 0;

            for (Impianto i : impianti) {
                if (i.getTecnici().contains(t)) {
                    incasso += i.getPrezzoInstallazione();
                }
            }

            if (incasso > importoMax) {
                importoMax = incasso;
                res = t;
            }
        }

        return res;
    }

    private LinkedList<String> getTecnici() {
        LinkedList<String> res = new LinkedList<>();

        for (Impianto i : impianti) {
            for (String t : i.getTecnici()) {
                if (!res.contains(t)) {
                    res.add(t);
                }
            }
        }

        return res;
    }



    public String scalaSimile(String cod, int d1, int d2) {
        int installazioni = getInstallazioni(cod, d1, d2);

        LinkedList<String> scale = getScale();
        for (String s : scale) {
            if (!s.equals(cod) && getInstallazioni(s, d1, d2) == installazioni) {
                return s;
            }
        }

        return null;
    }

    private int getInstallazioni(String s, int d1, int d2) {
        int res = 0;

        for (Impianto i : impianti) {
            if (d1 <= i.getDataInstallazione() && i.getDataInstallazione() <= d2) {
                for (Appartamento a : appartamenti) {
                    if (a.getCodice().equals(i.getAppartamento()) && a.getScala().equals(s)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }





    public static void main(String[] args) {
        Appartamento a1 = new Appartamento("A1", "S1");
        Appartamento a2 = new Appartamento("A2", "S1");
        Appartamento a3 = new Appartamento("A3", "S2");
        Appartamento a4 = new Appartamento("A4", "S2");
        Appartamento a5 = new Appartamento("A5", "S3");
        Appartamento a6 = new Appartamento("A6", "S3");

        LinkedList<String> l1 = new LinkedList<>();
        LinkedList<String> l2 = new LinkedList<>();
        LinkedList<String> l3 = new LinkedList<>();
        LinkedList<String> l4 = new LinkedList<>();
        LinkedList<String> l5 = new LinkedList<>();
        l1.add("Verdi");
        l1.add("Bianchi");
        l2.add("Verdi");
        l2.add("Rossi");
        l3.add("Rossi");
        l3.add("Bianchi");
        l4.add("Verdi");
        l5.add("Bianchi");

        Impianto i1 = new Impianto("A1", 120, 10, "fotovoltaico", l1);
        Impianto i2 = new Impianto("A1", 100, 20, "solare termico", l2);
        Impianto i3 = new Impianto("A2", 120, 30, "solare termico", l3);
        Impianto i4 = new Impianto("A3", 100, 15, "fotovoltaico", l2);
        Impianto i5 = new Impianto("A4", 120, 20, "fotovoltaico", l4);
        Impianto i6 = new Impianto("A5", 100, 25, "fotovoltaico", l5); 
        Impianto i7 = new Impianto("A6", 110, 35, "solare termico", l3);

        LinkedList<Appartamento> appartamenti = new LinkedList<>();
        appartamenti.add(a1);
        appartamenti.add(a2);
        appartamenti.add(a3);
        appartamenti.add(a4);
        appartamenti.add(a5);
        appartamenti.add(a6);

        LinkedList<Impianto> impianti = new LinkedList<>();
        impianti.add(i1);
        impianti.add(i2);
        impianti.add(i3);
        impianti.add(i4);
        impianti.add(i5);
        impianti.add(i6);
        impianti.add(i7);

        Sistema sistema = new Sistema(appartamenti, impianti);
        IO.println(sistema.scaleUnicoTipo());
        IO.println(sistema.tecnicoMax());
        IO.println(sistema.scalaSimile("S1", 10, 20));
    }
}
