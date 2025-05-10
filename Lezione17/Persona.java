package Lezione17;
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


    //metodo EQUALS - di default uguale a == (se non definito)

    /* in java, il metodo equals può essere applicato in maniera flessibile comparando anche oggetti di 
     * diverso tipo (ad esempio, comparando Persona con Cliente tramite nome e cognome).
     * Faccio ciò indicando una classe generica OBJECT - che riceve un oggetto di qualunque tipo,
     * poi eventualmente i limiti sono posti dentro al codice (indicando gli oggetti desiderati) con INSTANCEOF
     * 
     * ATTENZIONE - l'oggetto null è instanceof di nessuna classe
     */

    //questo metodo può essere eseguito solo su oggetti NON NULL perché dinamico -> this non sarà mai null
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Persona) {
            //adesso, sapendo che o è un tipo Persona, faccio un casting di tipo Persona (per accedere ai campi)
            //devo farlo altrimenti non posso accedere ai campi da un oggetto generico
            Persona p = (Persona)o;
            //adesso accederò ai campi tramite la variabile p
    
            /* ATTENZIONE - non posso chiamare l'equal su una stringa null, per cui */
            if (this.nome == null || this.cognome == null || p.nome == null || p.cognome == null) {
                return false;
            }
            //confronto, per esempio, solo nome, cognome, ed età
            if (this.nome.equals(p.nome) && 
                this.cognome.equals(p.cognome) && 
                this.eta == p.eta) {
                    return true;
            }
    
            return false;
        }
        else if (o instanceof Cliente) {
            Cliente c = (Cliente)o;

            if (this.nome == null || this.cognome == null || c.getNome() == null || c.getCognome() == null) {
                return false;
            }

            if (this.nome.equals(c.getNome()) &&
                this.cognome.equals(c.getCognome()) &&
                this.eta == c.getEta()) {
                    return true;
                }

            return false;
        }

        return false;
    }


}
