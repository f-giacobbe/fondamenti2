package Lezione12;
import IO.*;
public class Persona {
    private String nome;
    private String cognome;
    private int eta;
    private NumeroTelefonico numeroTelefonico;
    private int[] numeriFortunati;


    public Persona() {
    }

    public Persona(String nome, String cognome, int eta, NumeroTelefonico numeroTelefonico, int[] numeriFortunati) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.numeroTelefonico = numeroTelefonico;
        this.numeriFortunati = numeriFortunati;
    }



    //COSTRUTTORE COPIA - prende come argomento una persona già esistente
    /* ATTENZIONE - mentre va bene per int e Stringhe (perché immutabili), non assicura 
    /* il non-aliasing di altri oggetti
     * (es. NumeroTelefono)
     */
    public Persona(Persona p) {     //shallow copy - per via di NumeroTelefonico e numeriFortunati
        this.nome = p.nome;
        this.cognome = p.cognome;
        this.eta = p.eta;
        this.numeroTelefonico = p.numeroTelefonico;//
        this.numeriFortunati = p.numeriFortunati;//
    }


    //deep copy (lascia stare n)
    //per ogni oggetto mutabile ne crea uno nuovo
    public Persona(Persona p, int n) {
        this.nome = p.nome;
        this.cognome = p.cognome;
        this.eta = p.eta;
        this.numeroTelefonico = new NumeroTelefonico(p.numeroTelefonico);   //uso il costruttore copia
        this.numeriFortunati = deepCopyArray(p.numeriFortunati);
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
    
    public void setNumeriFortunati(int[] numeriFortunati) {
        this.numeriFortunati = numeriFortunati;
    }

    public int[] getNumeriFortunati() {
        return this.numeriFortunati;
    }


    public void stampaNumeriFortunati() {
        for (int i=0; i<(this.numeriFortunati).length; i++) {
            if (i==0) {
                IO.print("[");
            }
            IO.print(this.numeriFortunati[i]);
            if (i != (this.numeriFortunati).length -1) {
                IO.print("; ");
            }
            else {
                IO.print("]");
            }
        }
    }

 

    public String toString() {
        return "Nome: " + this.nome + "; " +
                "Cognome: " + this.cognome + "; " +
                "Età: " + this.eta + "; " +
                "Numero telefonico: " + this.numeroTelefonico;
    }



    public static int[] deepCopyArray(int[] a) {
        int[] res = new int[a.length];

        for (int i=0; i<a.length; i++) {
            res[i] = a[i];
        }

        return res;
    }
}
