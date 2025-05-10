package Lezione19;

class NodoInt {
    private int info;
    private NodoInt successore;



    public NodoInt() {
        this.info = 0;
        this.successore = null;
    }


    public NodoInt(int info, NodoInt successore) {
        this.info = info;
        this.successore = successore;
    }



    public int getInfo() {
        return info;
    }


    public void setInfo(int info) {
        this.info = info;
    }


    public NodoInt getSuccessore() {
        return successore;
    }


    public void setSuccessore(NodoInt successore) {
        this.successore = successore;
    }



    public String toString() {
        return "" + this.info;
    }
}





public class ListaConcatenataInt {
    private NodoInt testa;
    private NodoInt coda;
    private int lunghezza;



    public ListaConcatenataInt() {
        this.testa = null;
        this.coda = null;
        this.lunghezza = 0;
    }


    public ListaConcatenataInt(int[] a) {
        if (a == null || a.length == 0) {
            this.testa = null;
            this.coda = null;
            this.lunghezza = 0;
        }
        else {
            for (int el : a) {
                this.aggiungiInCoda(el);
            }
        }
    }


    public ListaConcatenataInt(ListaConcatenataInt l) {
        if (l == null || l.getLunghezza() == 0) {
            this.testa = null;
            this.coda = null;
            this.lunghezza = 0;
        }
        else {
            for (NodoInt it = l.testa; it!=null; it=it.getSuccessore()) {
                this.aggiungiInCoda(it.getInfo());
            }
        }
    }



    public int getLunghezza() {
        return this.lunghezza;
    }



    public void aggiungiInTesta(int info) {
        NodoInt nuovaTesta = new NodoInt(info, this.testa);

        this.testa = nuovaTesta;

        if (this.lunghezza == 0) {
            this.coda = nuovaTesta;
        }

        this.lunghezza++;
    }



    public void aggiungiInCoda(int info) {
        NodoInt nuovaCoda = new NodoInt(info, null);
        
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
            throw new RuntimeException();
        }

        this.testa = this.testa.getSuccessore();

        if (this.lunghezza == 1) {
            this.coda = null;
        }

        lunghezza--;
    }



    public void rimuoviCoda() {
        if (this.lunghezza == 0) {
            throw new RuntimeException();
        }

        if (this.lunghezza == 1) {
            this.testa = null;
            this.coda = null;
        }
        else {
            NodoInt it = this.testa;
            for (int i=0; i<this.lunghezza-2; i++) {
                it = it.getSuccessore();
            }
    
            it.setSuccessore(null);
            this.coda = it;
        }
        
        lunghezza--;
    }



    public void aggiungiInPosizione(int info, int pos) {
        if (pos < 0 || pos > this.lunghezza) {
            throw new RuntimeException();
        }

        if (pos == 0) {
            aggiungiInTesta(info);
            return;
        }
        if (pos == this.lunghezza) {
            aggiungiInCoda(info);
            return;
        }

        int i = 1;
        NodoInt it = this.testa;
        while (i < pos) {
            i++;
            it = it.getSuccessore();
        }

        NodoInt nuovoNodoInt = new NodoInt(info, it.getSuccessore());
        it.setSuccessore(nuovoNodoInt);
        this.lunghezza++;
    }



    public void modificaInPosizione(int info, int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos > this.lunghezza-1) {
            throw new RuntimeException("Indice non valido.");
        }

        NodoInt it = this.testa;
        int i = 0;
        while (i != pos) {
            it = it.getSuccessore();
            i++;
        }

        it.setInfo(info);
    }



    public void rimuoviPosizione(int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos > this.lunghezza-1) {
            throw new RuntimeException();
        }

        if (pos == 0) {
            this.rimuoviTesta();
            return;
        }
        if (pos == this.lunghezza-1) {
            this.rimuoviCoda();
            return;
        }
        
        NodoInt it = this.testa;
        int i = 0;
        while (i < pos-1) {
            it = it.getSuccessore();
            i++;
        }

        it.setSuccessore(it.getSuccessore().getSuccessore());
        lunghezza--;
    }


    
    public String toString() {
        String res = "[";
        
        for (NodoInt it = this.testa; it != null; it = it.getSuccessore()) {
            res += it;
            
            if (it.getSuccessore() != null)
            res += "; ";
        }
        
        return res + "]";
    }



    public int get(int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos >= this.lunghezza) {
            throw new RuntimeException("Indice non valido");
        }
    
        NodoInt it = this.testa;
        for (int i=0; i != pos; i++) {
            it = it.getSuccessore();
        }
    
        return it.getInfo();
    }



    public int[] restituisciArray() {
        int[] res = new int[this.lunghezza];

        int i = 0;
        for (NodoInt it = this.testa; it!=null; it = it.getSuccessore()) {
            res[i] = it.getInfo();
            i++;
        }

        return res;
    }



    public boolean equals(ListaConcatenataInt l) {
        if (this == l) {
            return true;
        }
        
        if (l == null || this.lunghezza != l.lunghezza) {
            return false;
        }

        NodoInt it1 = this.testa;
        NodoInt it2 = l.testa;
        for (int i=0; i<this.lunghezza; i++) {
            if (it1.getInfo() != it2.getInfo()) {
                return false;
            }
            it1 = it1.getSuccessore();
            it2 = it2.getSuccessore();
        }

        return true;
    }



    public int contaCoppie(int k) {
        return contaCoppie(k, this.testa);
    }

    private int contaCoppie(int k, NodoInt it) {
        if (it.getSuccessore() == null) {
            return 0;
        }

        if (it.getInfo() < k && it.getSuccessore().getInfo() >= k) {
            return 1 + contaCoppie(k, it.getSuccessore());
        }

        return contaCoppie(k, it.getSuccessore());
    }



    /* verificare ricorsivamente se in una ListaConcatenataInt le somme dei numeri pari e dispari sono uguali */
    public boolean sommeUguali() {
        return sommeUguali(this.testa, 0, 0);
    }

    private boolean sommeUguali(NodoInt it, int sommaPari, int sommaDispari) {
        if (it == null) {
            return sommaPari == sommaDispari;
        }

        if (it.getInfo() % 2 == 0) {
            return sommeUguali(it.getSuccessore(), sommaPari + it.getInfo(), sommaDispari);
        }

        return sommeUguali(it.getSuccessore(), sommaPari, sommaDispari + it.getInfo());
    }
}