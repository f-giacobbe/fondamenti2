package Lezione11;
import IO.*;
public class Persona {
    private String nome;
    private String cognome;
    private int eta;
    private NumeroTelefonico numeroTelefonico;


    public Persona() {
    }

    public Persona(String nome, String cognome, int eta, NumeroTelefonico numeroTelefonico) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.numeroTelefonico = numeroTelefonico;
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



    public void leggiPersona() {
        this.nome = IO.readString("Scrivi nome: ");
        this.cognome = IO.readString("Scrivi cognome: ");
        this.eta = IO.readInt("Digita età: ");
    }





    //esempio metodo statico
    public static void stampa(Persona p) {
        IO.println("Questa è un'invocazione del metodo statico STAMPA");
        IO.println("La persona passata come argomento si chiama: " + p.nome + " " + p.getCognome());

        //nei metodi statici NON SI PUO USARE "THIS", in quanto non prendono oggetti come prefissi
        //this.nome <-- NO
    }

    //posso chiamare due metodi statici e dinamici allo stesso modo

    public void stampa() {
        IO.println("Questa è un'invocazione del metodo dinamico STAMPA");
        IO.println("La persona su cui è stata effettuata l'invocazione si chiama: " + this.nome + " " + this.getCognome());
    }


    
    //metodo che restituisce una nuova persona
    public static Persona creaPersona() {
        IO.println("Creo un nuovo oggetto Persona leggendo i suoi dati da input");

        Persona p = new Persona();

        p.setNome(IO.readString("Scrivi nome: "));
        p.setCognome(IO.readString("Scrivi cognome: "));
        
        while (p.getEta() <= 0) {
            p.setEta(IO.readInt("Digita età: "));
        }


        return p;
    }



    //ESERCIZIO
    /* metodo che prende due persone e restituisce il nome della persona con l'età più bassa
     * (sia in forma dinamica che statica)
     */
    public String etaMinore(Persona p2) {
        if (this.eta < p2.eta) {
            return this.nome + " " + this.cognome;
        }

        return p2.nome + " " + p2.cognome;
    }

    public static String etaMinore(Persona p1, Persona p2) {
        if (p1.eta < p2.eta) {
            return p1.nome + " " + p1.cognome; 
        }

        return p2.nome + " " + p2.cognome;
    }
}
