package Esercitazione6.listeconcatenate;

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



    //inizio esercitazione
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



    public String stampaElementiInPosizionePari() {
        String s = "[";

        int i=0;
        for (Nodo it = this.testa; it != null; it = it.getSuccessore()) {
            if (i%2==0) {
                s += it + " ";
            }

            i++;
        }

        return s + "]";
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



    public static ListaConcatenataInt listaNumeriMaggiori(ListaConcatenataInt l) {
        //restituisce una lista contenente solo i numeri maggiori di almeno uno tra prec. e succ.
    
        ListaConcatenataInt res = new ListaConcatenataInt();
        
        if (l == null || l.lunghezza == 0 || l.lunghezza == 1) {
            return res;
        }

        Nodo prec = null;
        Nodo curr = l.testa;

        while (curr != null) {
            //testa
            if (prec == null && curr.getInfo() > curr.getSuccessore().getInfo()) {
                res.aggiungiInCoda(curr.getInfo());
            }
            //coda
            else if (curr.getSuccessore() == null) {
                if (curr.getInfo() > prec.getInfo()) {
                    res.aggiungiInCoda(curr.getInfo());
                }

                break;
            }
            else {
                if (curr.getInfo() > prec.getInfo() || curr.getInfo() > curr.getSuccessore().getInfo()) {
                    res.aggiungiInCoda(curr.getInfo());
                }
            }

            prec = curr;
            curr = curr.getSuccessore();
        }

        return res;
    }



    /* esercizio ricorsivo - calcolare la lunghezza di una lista */
    public static int lunghezzaRicorsiva(ListaConcatenataInt l) {
        if (l.testa == null) {
            return 0;
        }

        return lunghezzaRicorsiva(l.testa);
    }


    private static int lunghezzaRicorsiva(Nodo it) {
        if (it == null) {
            return 0;
        }

        return 1 + lunghezzaRicorsiva(it.getSuccessore());
    }
}
