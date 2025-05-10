package Esercitazione8.listeconcatenate;

class NodoIntDoppio {
    private int info;
    private NodoIntDoppio successore;
    private NodoIntDoppio predecessore;



    public NodoIntDoppio() {
        this.info = 0;
        this.successore = null;
        this.predecessore = null;
    }


    public NodoIntDoppio(int info, NodoIntDoppio successore, NodoIntDoppio predecessore) {
        this.info = info;
        this.successore = successore;
        this.predecessore = predecessore;
    }



    public int getInfo() {
        return info;
    }


    public void setInfo(int info) {
        this.info = info;
    }


    public NodoIntDoppio getSuccessore() {
        return successore;
    }


    public void setSuccessore(NodoIntDoppio successore) {
        this.successore = successore;
    }
    
    public NodoIntDoppio getPredecessore() {
        return predecessore;
    }


    public void setPredecessore(NodoIntDoppio predecessore) {
        this.predecessore = predecessore;
    }



    public String toString() {
        return "" + this.info;
    }
}





public class ListaConcatenataIntDoppia {
    private NodoIntDoppio testa;
    private NodoIntDoppio coda;
    private int lunghezza;



    public ListaConcatenataIntDoppia() {
        this.testa = null;
        this.coda = null;
        this.lunghezza = 0;
    }


    public ListaConcatenataIntDoppia(int[] a) {
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


    public ListaConcatenataIntDoppia(ListaConcatenataIntDoppia l) {
        if (l == null || l.getLunghezza() == 0) {
            this.testa = null;
            this.coda = null;
            this.lunghezza = 0;
        }
        else {
            for (NodoIntDoppio it = l.testa; it!=null; it=it.getSuccessore()) {
                this.aggiungiInCoda(it.getInfo());
            }
        }
    }



    public int getLunghezza() {
        return this.lunghezza;
    }



    public void aggiungiInTesta(int info) {
        NodoIntDoppio nuovaTesta = new NodoIntDoppio(info, this.testa, null);

        if (this.lunghezza == 0) {
            this.coda = nuovaTesta;
        }
        else {
            this.testa.setPredecessore(nuovaTesta);
        }

        this.testa = nuovaTesta;

        this.lunghezza++;
    }



    public void aggiungiInCoda(int info) {
        NodoIntDoppio nuovaCoda = new NodoIntDoppio(info, null, this.coda);
        
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
        this.testa.setPredecessore(null);

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
            NodoIntDoppio it = this.testa;
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
        NodoIntDoppio it = this.testa;
        while (i < pos) {
            i++;
            it = it.getSuccessore();
        }

        NodoIntDoppio nuovoNodoIntDoppio = new NodoIntDoppio(info, it.getSuccessore(), it);
        it.setSuccessore(nuovoNodoIntDoppio);
        it = it.getSuccessore();
        it = it.getSuccessore();
        it.setPredecessore(nuovoNodoIntDoppio);
        this.lunghezza++;
    }



    public void modificaInPosizione(int info, int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos > this.lunghezza-1) {
            throw new RuntimeException("Indice non valido.");
        }

        NodoIntDoppio it = this.testa;
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
        
        NodoIntDoppio it = this.testa;
        int i = 0;
        while (i < pos-1) {
            it = it.getSuccessore();
            i++;
        }

        it.setSuccessore(it.getSuccessore().getSuccessore());
        it.getSuccessore().setPredecessore(it);
        lunghezza--;
    }


    
    public String toString() {
        String res = "[";
        
        for (NodoIntDoppio it = this.testa; it != null; it = it.getSuccessore()) {
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
    
        NodoIntDoppio it = this.testa;
        for (int i=0; i != pos; i++) {
            it = it.getSuccessore();
        }
    
        return it.getInfo();
    }



    public int[] restituisciArray() {
        int[] res = new int[this.lunghezza];

        int i = 0;
        for (NodoIntDoppio it = this.testa; it!=null; it = it.getSuccessore()) {
            res[i] = it.getInfo();
            i++;
        }

        return res;
    }



    public boolean equals(ListaConcatenataIntDoppia l) {
        if (this == l) {
            return true;
        }
        
        if (l == null || this.lunghezza != l.lunghezza) {
            return false;
        }

        NodoIntDoppio it1 = this.testa;
        NodoIntDoppio it2 = l.testa;
        for (int i=0; i<this.lunghezza; i++) {
            if (it1.getInfo() != it2.getInfo()) {
                return false;
            }
            it1 = it1.getSuccessore();
            it2 = it2.getSuccessore();
        }

        return true;
    }



    public boolean verifica(int lungMin, int n) {
        if (this.testa == null || this.testa.getInfo() == n || this.lunghezza <= lungMin) {
            return false;
        }

        return verifica(lungMin, n, this.testa.getSuccessore(), 1, this.testa.getInfo() < n ? -1 : 1);
    }

    private boolean verifica(int lungMin, int n, NodoIntDoppio it, int inARow, int minOMax) {
        /* la variabile inARow memorizza la lunghezza della sottosequenza corrente;
         * la variabile minOMax  varrà -1 se la sottosequenza corrente è formata
         * da numeri strettamente minori di n, mentre varrà 1 se formata da numeri strettamente maggiori
         * di n
         */

        if (it == null) {
            return inARow > lungMin;
        }

        if (it.getInfo() == n) {
            return false;
        }

        if ((minOMax == -1 && it.getInfo() < n) || (minOMax == 1 && it.getInfo() > n)) {
            return verifica(lungMin, n, it.getSuccessore(), inARow+1, minOMax);
        }

        //interruzione sequenza
        if (inARow <= lungMin) {
            return false;
        }

        return verifica(lungMin, n, it.getSuccessore(), 1, it.getInfo() < n ? -1 : 1);
    }



    public int stampaPrecedentePos(int pos) {
        NodoIntDoppio it = this.testa;
        for (int i = 0; i <= pos; i++) {
            if (i == pos) {
                return it.getPredecessore().getInfo();
            }

            it = it.getSuccessore();
        }

        return 0;
    }
}