package Lezione10;
import IO.*;
public class Persona2 {
    private String nome;
    private String cognome;
    private int eta;



    public Persona2() {}
    
    public Persona2(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }



    public String toString() {
        return "Nome: " + nome + "; " + "Cognome: " + cognome + "; " + "Età: " + eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public int getEta() {
        return this.eta;
    }


    
    public void leggiPersona() {
        this.nome = IO.readString("Scrivi nome: ");
        this.cognome = IO.readString("Scrivi cognome: ");
        this.eta = IO.readInt("Digita età: ");
    }
}
