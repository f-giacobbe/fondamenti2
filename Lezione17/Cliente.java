package Lezione17;
import java.util.Arrays;
public class Cliente {
    private String nome;
    private String cognome;
    private int eta;
    private int[] numeriFortunati;


    public Cliente(String nome, String cognome, int eta, int[] numeriFortunati) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.numeriFortunati = numeriFortunati;     //attenzione! aliasing
    }

    public Cliente(Cliente c) { //deep copy
        this.nome = c.nome;
        this.cognome = c.cognome;
        this.eta = c.eta;

        if (c.numeriFortunati != null) {
            this.numeriFortunati = new int[c.numeriFortunati.length];    //supponendo sia esistente
    
            //copia array - non funziona nel caso in cui l'array di this sia null (per via di length)
            for (int i=0; i<this.numeriFortunati.length; i++) {
                this.numeriFortunati[i] = c.numeriFortunati[i];
            }
        }
    }

    
    public String toString() {
        return "Cliente [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", numeriFortunati="
                + Arrays.toString(numeriFortunati) + "]";
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int[] getNumeriFortunati() {
        return numeriFortunati;
    }

    public void setNumeriFortunati(int[] numeriFortunati) {
        this.numeriFortunati = numeriFortunati;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Persona) { //confronto solo nome, cognome, età
            Persona p = (Persona)o;

            if (this.nome == null || this.cognome == null || p.getNome() == null || p.getCognome() == null) {
                return false;
            }

            if (this.nome.equals(p.getNome()) && this.cognome.equals(p.getCognome()) && this.eta == p.getEta()) {
                return true;
            }

            return false;
        }
        else if (o instanceof Cliente) {    //confronto nome, cognome, età, numeriFortunati
            Cliente c = (Cliente)o;

            if (this.nome == null || this.cognome == null || c.nome == null || c.cognome == null) {
                return false;
            }

            if (this.nome.equals(c.nome) && this.cognome.equals(c.cognome) && this.eta == c.eta) {
                return ugualeArray(this.numeriFortunati, c.numeriFortunati);
            }

            return false;
        }

        return false;
    }



    public static boolean ugualeArray(int[] a1, int[] a2) {
        //verifica se tutti gli elementi del primo array sono contenuti nel secondo
        if (a1 == null && a2 == null) {
            return true;
        }

        if ((a1 == null && a2 != null) || (a1 != null && a2 == null)) {
            return false;
        }

        if (a1.length != a2.length) {
            return false;
        }

        for (int i=0; i<a1.length; i++) {
            int x = a1[i];
            boolean trovato = false;

            for (int j=0; j<a2.length; j++) {
                if (a2[j] == x) {
                    trovato = true;
                    break;
                }
            }

            if (!trovato) {
                return false;
            }
        }

        return true;
    }
}
