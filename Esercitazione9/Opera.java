package Esercitazione9;

public class Opera {
    private String nome;
    private String autore;
    private int anno;

    

    public Opera(String nome, String autore, int anno) {
        this.nome = nome;
        this.autore = autore;
        this.anno = anno;
    }
    
    public String getNome() {
        return nome;
    }
    public String getAutore() {
        return autore;
    }
    public int getAnno() {
        return anno;
    }
    @Override
    public String toString() {
        return "Opera [nome=" + nome + ", autore=" + autore + ", anno=" + anno + "]";
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Opera))
            return false;

        Opera opera2 = (Opera) o;

        if (this.nome.equals(opera2.nome) && this.autore.equals(opera2.autore) && this.anno == opera2.anno)
            return true;

        return false;
    }
}
