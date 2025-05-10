package Esercitazione8;
import java.util.*;
public class Impianto {
    private String appartamento;
    private int prezzoInstallazione;
    private int dataInstallazione;
    private String tipo;
    private LinkedList<String> tecnici;

    
    public Impianto(String appartamento, int prezzoInstallazione, int dataInstallazione, String tipo,
            LinkedList<String> tecnici) {
        this.appartamento = appartamento;
        this.prezzoInstallazione = prezzoInstallazione;
        this.dataInstallazione = dataInstallazione;
        this.tipo = tipo;

        this.tecnici = new LinkedList<>();
        for (String t : tecnici) {
            this.tecnici.add(t);
        }
    }


    public String getAppartamento() {
        return appartamento;
    }


    public int getPrezzoInstallazione() {
        return prezzoInstallazione;
    }


    public int getDataInstallazione() {
        return dataInstallazione;
    }


    public String getTipo() {
        return tipo;
    }


    public LinkedList<String> getTecnici() {
        return tecnici;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Impianto)) {
            return false;
        }

        Impianto ipt = (Impianto) o;

        return this.appartamento.equals(ipt.appartamento) && this.prezzoInstallazione == ipt.prezzoInstallazione
        && this.dataInstallazione == ipt.dataInstallazione && this.tipo.equals(ipt.tipo)
        && this.tecnici.equals(ipt.tecnici);
    }


    public String toString() {
        return "[Appartamento: " + this.appartamento + "; Prezzo Installazione: " + this.prezzoInstallazione + 
                "; Data Installazione: " + this.dataInstallazione + "; Tipo: " + this.tipo + 
                "; Tecnici: " + this.tecnici;
    }
}
