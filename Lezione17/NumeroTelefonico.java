package Lezione17;
public class NumeroTelefonico {
    private String prefisso;
    private String numero;



    public NumeroTelefonico(String prefisso, String numero) {
        this.prefisso = prefisso;
        this.numero = numero;
    }

    
    public NumeroTelefonico(NumeroTelefonico nt) {
        this.prefisso = nt.prefisso;
        this.numero = nt.numero;
    }



    public String getPrefisso() {
        return prefisso;
    }



    public void setPrefisso(String prefisso) {
        this.prefisso = prefisso;
    }



    public String getNumero() {
        return numero;
    }



    public void setNumero(String numero) {
        this.numero = numero;
    }
    


    public String toString() {
        return "Prefisso: " + this.prefisso + "; Numero: " + this.numero;
    }
}
