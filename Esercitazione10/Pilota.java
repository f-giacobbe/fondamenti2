package Esercitazione10;

public class Pilota {
    private String nome;
    private int eta;
    private float compensoPerGara;
    
    public String getNome() {
        return nome;
    }
    public int getEta() {
        return eta;
    }
    public float getCompensoPerGara() {
        return compensoPerGara;
    }

    public Pilota(String nome, int eta, float compensoPerGara) {
        this.nome = nome;
        this.eta = eta;
        this.compensoPerGara = compensoPerGara;
    }
    @Override
    public String toString() {
        return "Pilota [nome=" + nome + ", eta=" + eta + ", compensoPerGara=" + compensoPerGara + "]";
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Pilota))
            return false;

        Pilota p2 = (Pilota)o;

        if (this.nome.equals(p2.nome) && this.eta == p2.eta && this.compensoPerGara == p2.compensoPerGara)
            return true;

        return false;
    }
}
