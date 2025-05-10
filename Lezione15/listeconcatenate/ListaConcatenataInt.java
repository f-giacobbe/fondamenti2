package Lezione15.listeconcatenate;

class Nodo {
    private int info;
    private Nodo successore;



    public Nodo() {
        this.info = 0;
        this.successore = null;
    }


    public Nodo(int info, Nodo successore) {
        this.info = info;
        this.successore = successore;
    }



    public int getInfo() {
        return info;
    }


    public void setInfo(int info) {
        this.info = info;
    }


    public Nodo getSuccessore() {
        return successore;
    }


    public void setSuccessore(Nodo successore) {
        this.successore = successore;
    }



    public String toString() {
        return "" + this.info;
    }
}





public class ListaConcatenataInt {
    private Nodo testa;
    private Nodo coda;
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
            for (Nodo it = l.testa; it!=null; it=it.getSuccessore()) {
                this.aggiungiInCoda(it.getInfo());
            }
        }
    }



    public int getLunghezza() {
        return this.lunghezza;
    }



    public void aggiungiInTesta(int info) {
        Nodo nuovaTesta = new Nodo(info, this.testa);

        this.testa = nuovaTesta;

        if (this.lunghezza == 0) {
            this.coda = nuovaTesta;
        }

        this.lunghezza++;
    }



    public void aggiungiInCoda(int info) {
        Nodo nuovaCoda = new Nodo(info, null);
        
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
            Nodo it = this.testa;
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
        Nodo it = this.testa;
        while (i < pos) {
            i++;
            it = it.getSuccessore();
        }

        Nodo nuovoNodo = new Nodo(info, it.getSuccessore());
        it.setSuccessore(nuovoNodo);
        this.lunghezza++;
    }



    public void modificaInPosizione(int info, int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos > this.lunghezza-1) {
            throw new RuntimeException("Indice non valido.");
        }

        Nodo it = this.testa;
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
        
        Nodo it = this.testa;
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
        
        for (Nodo it = this.testa; it != null; it = it.getSuccessore()) {
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
    
        Nodo it = this.testa;
        for (int i=0; i != pos; i++) {
            it = it.getSuccessore();
        }
    
        return it.getInfo();
    }



    public int[] restituisciArray() {
        int[] res = new int[this.lunghezza];

        int i = 0;
        for (Nodo it = this.testa; it!=null; it = it.getSuccessore()) {
            res[i] = it.getInfo();
            i++;
        }

        return res;
    }



    ///SECONDO ESERCIZIO D'ESAME RICORSIVO
    /* metodo ricorsivo - somma elementi lista */
    public int sommaElementi() {
        return sommaElementi(this.testa);
    }


    private int sommaElementi(Nodo it) {
        if (it == null) {
            return 0;
        }

        return it.getInfo() + sommaElementi(it.getSuccessore());
    }



    /* metodo senza nodo come parametro */
    public int sommaElementi2() {
        if (this.testa == null) {
            return 0;
        }

        ListaConcatenataInt l_sliced = new ListaConcatenataInt(this);
        l_sliced.rimuoviTesta();

        return this.testa.getInfo() + l_sliced.sommaElementi2();
    }



    /* più efficiente (niente copie di liste) */
    public int sommaElementi3() {
        if (this.testa == null) {
            return 0;
        }

        int vecchiaTesta = this.testa.getInfo();
        this.rimuoviTesta();

        int somma = vecchiaTesta + this.sommaElementi3();

        this.aggiungiInTesta(vecchiaTesta);

        return somma;
    }



    public int sommaElementi4() {
        return this.sommaElementi(this.lunghezza);
    }


    private int sommaElementi(int rimasti) {
        if (rimasti == 0) {
            return 0;
        }

        int vecchiaTesta = this.testa.getInfo();

        this.rimuoviTesta();
        this.aggiungiInCoda(vecchiaTesta);

        int somma = vecchiaTesta + sommaElementi(rimasti - 1);
        return somma;
    }



    public boolean eOrdinataCrescenteIt() {
        for (Nodo it = this.testa; it.getSuccessore()!=null; it=it.getSuccessore()) {
            if (it.getInfo() > it.getSuccessore().getInfo()) {
                return false;
            }
        }

        return true;
    }



    public boolean eOrdinataCrescenteRic() {
        return eOrdinataCrescenteRic(this.testa);
    }

    private boolean eOrdinataCrescenteRic(Nodo it) {
        if (it == null || it.getSuccessore() == null) {
            return true;
        }

        if (it.getInfo() > it.getSuccessore().getInfo()) {
            return false;
        }

        return eOrdinataCrescenteRic(it.getSuccessore());
    }



    public ListaConcatenataInt sottoSequenzaPariIt() {
        ListaConcatenataInt res = new ListaConcatenataInt();

        for (Nodo it=this.testa; it!=null; it=it.getSuccessore()) {
            if (it.getInfo() % 2 == 0) {
                res.aggiungiInCoda(it.getInfo());
            }
        }

        return res;
    }



    public ListaConcatenataInt sottoSequenzaPariRic() {
        ListaConcatenataInt res = new ListaConcatenataInt();

        return this.sottoSequenzaPariRic(res, this.testa);
    }

    private ListaConcatenataInt sottoSequenzaPariRic(ListaConcatenataInt sl, Nodo it) {
        if (it == null) {
            return sl;
        }

        if (it.getInfo() % 2 == 0) {
            sl.aggiungiInCoda(it.getInfo());
        }

        return sottoSequenzaPariRic(sl, it.getSuccessore());
    }



    public void modificaIt() {
        int i = 0;
        for (Nodo it=this.testa; it.getSuccessore()!=null; it=it.getSuccessore()) {
            if (it.getInfo() == it.getSuccessore().getInfo() && it.getInfo() != 0) {
                this.aggiungiInPosizione(0, i+1);
            }

            i++;
        }

        return;
    }



    public void modificaRic() {
        this.modificaRic(0, this.testa);
        return;
    }

    private void modificaRic(int i, Nodo it) {
        if (it.getSuccessore() == null || it == null) {
            return;
        }

        if (it.getInfo() == it.getSuccessore().getInfo() && it.getInfo() != 0) {
            this.aggiungiInPosizione(0, i+1);
        }

        this.modificaRic(i+1, it.getSuccessore());
        return;
    }



    public boolean equals(ListaConcatenataInt l) {
        if (this == l) {
            return true;
        }
        
        if (l == null || this.lunghezza != l.lunghezza) {
            return false;
        }

        Nodo it1 = this.testa;
        Nodo it2 = l.testa;
        for (int i=0; i<this.lunghezza; i++) {
            if (it1.getInfo() != it2.getInfo()) {
                return false;
            }
            it1 = it1.getSuccessore();
            it2 = it2.getSuccessore();
        }

        return true;
    }
}