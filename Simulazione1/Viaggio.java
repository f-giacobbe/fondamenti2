package Simulazione1;

public class Viaggio {
    private String codice;
    private String destinazione;
    private int durata;
    private int numPasseggeri;

    public Viaggio() {
        this.codice = null;
        this.destinazione = null;
        this.durata = 0;
        this.numPasseggeri = 0;
    }

    public Viaggio(String codice, String destinazione, int durata, int numPasseggeri) {
        this.codice = codice;
        this.destinazione = destinazione;
        this.durata = durata;
        this.numPasseggeri = numPasseggeri;
    }

    public String getCodice() {
        return codice;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public int getDurata() {
        return durata;
    }

    public int getNumPasseggeri() {
        return numPasseggeri;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Viaggio))
            return false;

        Viaggio v = (Viaggio)o;

        if (this.codice.equals(v.codice) && this.destinazione.equals(v.destinazione) &&
            this.durata == v.durata && this.numPasseggeri == v.numPasseggeri)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "Viaggio [codice=" + codice + ", destinazione=" + destinazione + ", durata=" + durata
                + ", numPasseggeri=" + numPasseggeri + "]";
    }
}