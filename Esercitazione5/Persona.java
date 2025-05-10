package Esercitazione5;
import IO.*;
public class Persona {
    private String nome;
    private String cognome;
    private int eta;
    private NumeroTelefonico numeroTelefonico;


    public Persona() {
    }

    public Persona(String nome, String cognome, int eta, NumeroTelefonico numeroTelefonico, int[] numeriFortunati) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.numeroTelefonico = numeroTelefonico;
    }


    public Persona(Persona p) {
        this.nome = p.nome;
        this.cognome = p.cognome;
        this.eta = p.eta;
        this.numeroTelefonico = new NumeroTelefonico(p.numeroTelefonico);
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

    public NumeroTelefonico getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(NumeroTelefonico numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    

    public String toString() {
        return "Nome: " + this.nome + "; " +
                "Cognome: " + this.cognome + "; " +
                "Età: " + this.eta + "; " +
                "Numero telefonico: " + this.numeroTelefonico;
    }


    public static Persona leggiPersona() {
        Persona p = new Persona();

        p.nome = IO.readString("Scrivi nome: ");
        p.cognome = IO.readString("Scrivi cognome: ");
        p.eta = IO.readInt("Digita età: ");

        return p;
    }



    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Persona) {
            Persona p = (Persona)o;

            if (this.nome == null || this.cognome == null) {
                return false;
            }

            return this.nome.equals(p.nome) && this.cognome.equals(p.cognome) && this.eta == p.eta
                    && this.numeroTelefonico.equals(p.numeroTelefonico);
        }
        else if (o instanceof Cliente) {
            Cliente c = (Cliente)o;

            if (this.nome == null || this.cognome == null) {
                return false;
            }

            return this.nome.equals(c.getNome()) && this.cognome.equals(c.getCognome()) && this.eta == c.getEta();
        }

        return false;
    }


}
