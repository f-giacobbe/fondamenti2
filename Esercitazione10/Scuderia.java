package Esercitazione10;

public class Scuderia {
    private String nome;
    private String citta;
    private float compensoExtra;

    public String getNome() {
        return nome;
    }
    public String getCitta() {
        return citta;
    }
    public float getCompensoExtra() {
        return compensoExtra;
    }

    public Scuderia(String nome, String citta, float compensoExtra) {
        this.nome = nome;
        this.citta = citta;
        this.compensoExtra = compensoExtra;
    }
    @Override
    public String toString() {
        return "Scuderia [nome=" + nome + ", citta=" + citta + ", compensoExtra=" + compensoExtra + "]";
    }

    
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Scuderia))
            return false;

        Scuderia s2 = (Scuderia)o;

        if (this.nome.equals(s2.nome) && this.citta.equals(s2.citta) && this.compensoExtra == s2.compensoExtra)
            return true;

        return false;
    }
}
