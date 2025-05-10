package Esercitazione5;
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

    public String getNumero() {
        return numero;
    }


    public String toString() {
        return "Prefisso: " + this.prefisso + "; Numero: " + this.numero;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof NumeroTelefonico)) {
            return false;
        }

        NumeroTelefonico n2 = (NumeroTelefonico)o;

        if (this.prefisso == null || this.numero == null) {
            return false;
        }

        return this.prefisso.equals(n2.prefisso) && this.numero.equals(n2.numero);
    }
}
