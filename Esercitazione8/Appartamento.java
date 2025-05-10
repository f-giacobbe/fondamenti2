package Esercitazione8;

public class Appartamento {
    private String codice;
    private String scala;



    public Appartamento(String codice, String scala) {
        this.codice = codice;
        this.scala = scala;
    }



    public String toString() {
        return "[Codice: " + codice + "; Scala: " + scala + "]";
    }



    public String getCodice() {
        return this.codice;
    }

    public String getScala() {
        return this.scala;
    }



    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Appartamento)) {
            return false;
        }

        Appartamento apt = (Appartamento) o;

        return this.codice.equals(apt.codice) && this.scala.equals(apt.scala);
    }
}
