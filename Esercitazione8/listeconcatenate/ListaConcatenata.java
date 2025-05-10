package Esercitazione8.listeconcatenate;
class Nodo<T> {
    private T info;
    private Nodo<T> successore;


    public Nodo() {
        this.info = null;
        this.successore = null;
    }

    public Nodo(T info, Nodo<T> successore) {
        this.info = info;
        this.successore = successore;
    }
    


    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getSuccessore() {
        return successore;
    }

    public void setSuccessore(Nodo<T> successore) {
        this.successore = successore;
    }

    public String toString() {
        return "" + this.info;
    }
}





public class ListaConcatenata<T> {
    private Nodo<T> testa;
    private Nodo<T> coda;
    private int lunghezza;


    public ListaConcatenata() {
        this.testa = null;
        this.coda = null;
        this.lunghezza = 0;
    }

    public ListaConcatenata(T[] a) {
        if (a == null || a.length == 0) {
            this.testa = null;
            this.coda = null;
            this.lunghezza = 0;
        }
        else {
            for (T el : a) {
                this.aggiungiInCoda(el);
            }
        }
    }

    public ListaConcatenata(ListaConcatenata<T> l) {
        if (l == null || l.lunghezza == 0) {
            this.testa = null;
            this.coda = null;
            this.lunghezza = 0;
        }
        else {
            for (Nodo<T> it = l.testa; it!=null; it=it.getSuccessore()) {
                this.aggiungiInCoda(it.getInfo());  //shallow copy
            }
        }
    }


    public int getLunghezza() {
        return this.lunghezza;
    }


    public String toString() {
        String res = "[";

        for (Nodo<T> it=this.testa; it!=null; it=it.getSuccessore()) {
            res += it;

            if (it.getSuccessore() != null) {
                res += "; ";
            }
        }

        return res + "]";
    }


    public boolean equals(ListaConcatenata<T> l) {
        if (this == l) {
            return true;
        }

        if (l == null || this.lunghezza != l.lunghezza) {
            return false;
        }

        Nodo<T> it1 = this.testa;
        Nodo<T> it2 = l.testa;
        for (int i=0; i<this.lunghezza; i++) {
            if (!(it1.getInfo().equals(it2.getInfo()))) {
                return false;
            }

            it1 = it1.getSuccessore();
            it2 = it2.getSuccessore();
        }

        return true;
    }



    public void aggiungiInTesta(T info) {
        Nodo <T> nuovaTesta = new Nodo<T>(info, this.testa);

        this.testa = nuovaTesta;

        if (this.lunghezza == 0) {
            this.coda = nuovaTesta;
        }

        this.lunghezza++;
    }


    public void aggiungiInCoda(T info) {
        Nodo<T> nuovaCoda = new Nodo<>(info, null);

        if (this.lunghezza == 0) {
            this.testa = nuovaCoda;
        }
        else {
            this.coda.setSuccessore(nuovaCoda);
        }

        this.coda = nuovaCoda;

        this.lunghezza++;
    }


    public void rimuoviTesta() {
        if (this.lunghezza == 0) {
            throw new RuntimeException("Nessuna testa da rimuovere");
        }

        this.testa = this.testa.getSuccessore();

        if (this.lunghezza == 1) {
            this.coda = null;
        }

        lunghezza--;
    }


    public void rimuoviCoda() {
        if (this.lunghezza == 0) {
            throw new RuntimeException("Nessuna coda da rimuovere");
        }

        if (this.lunghezza == 1) {
            this.testa = null;
            this.coda = null;
        }
        else {
            Nodo<T> it = this.testa;
            for (int i=0; i<this.lunghezza-2; i++) {
                it = it.getSuccessore();
            }

            it.setSuccessore(null);
            this.coda = it;
        }

        lunghezza--;
    }


    public void aggiungiInPosizione(T info, int pos) {
        if (pos < 0 || pos > this.lunghezza) {
            throw new RuntimeException("Posizione non valida");
        }

        if (pos == 0) {
            aggiungiInTesta(info);
            return;
        }
        if (pos == this.lunghezza) {
            aggiungiInCoda(info);
            return;
        }

        Nodo<T> it = this.testa;
        for (int i=1; i<pos; i++) {
            it = it.getSuccessore();
        }

        Nodo<T> nuovoNodo = new Nodo<T>(info, it.getSuccessore());
        it.setSuccessore(nuovoNodo);
        this.lunghezza++;
    }


    public void modificaInPosizione(T info, int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos > this.lunghezza) {
            throw new RuntimeException("Posizione non valida");
        }

        Nodo<T> it = this.testa;
        for (int i=0; i!=pos; i++) {
            it = it.getSuccessore();
        }

        it.setInfo(info);
    }


    public void rimuoviPosizione(int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos > this.lunghezza) {
            throw new RuntimeException("Posizione non valida");
        }

        if (pos == 0) {
            this.rimuoviTesta();
            return;
        }
        if (pos == this.lunghezza-1) {
            this.rimuoviCoda();
            return;
        }

        Nodo<T> it = this.testa;
        for (int i=0; i<pos-1; i++) {
            it = it.getSuccessore();
        }

        it.setSuccessore(it.getSuccessore().getSuccessore());
        this.lunghezza--;
    }



    public T get(int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos >= this.lunghezza) {
            throw new RuntimeException("Posizione non valida");
        }

        Nodo<T> it = this.testa;
        for (int i=0; i!=pos; i++) {
            it = it.getSuccessore();
        }

        return it.getInfo();
    }



    public T[] restituisciArray() {
        @SuppressWarnings ("unchecked")
        T[] res = (T[]) new Object[this.lunghezza];

        int i = 0;
        for (Nodo<T> it = this.testa; it != null; it = it.getSuccessore()) {
            res[i] = it.getInfo();
            i++;
        }

        return res;
    }
}
