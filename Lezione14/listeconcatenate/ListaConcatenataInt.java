package Lezione14.listeconcatenate;

//definisco la classe nodo
/* ATTENZIONE - dentro lo stesso file non è possibile creare due classi public
 * Posso creare più classi in un file solo se non pubbliche, e sarà accessibile solo all'interno del package
 * In questo caso, non voglio che la classe Nodo sia accessibile all'esterno.
 */
class Nodo {
    private int info;   //il contenuto del nodo
    private Nodo successore;  //ricorsivamente il successore è un nodo stesso



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
        return "" + this.info;  //type casting con stringa vuota
    }
}





public class ListaConcatenataInt {
    private Nodo testa;     //primo elemento
    private Nodo coda;      //ultimo elemento
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



    //aggiunta elemento all'inizio della lista
    /* astrattamente creo un nodo, metto la testa corrente come successore del nuovo nodo, come
     * nuova testa metto il nuovo nodo, e aggiungo 1 alla lunghezza.
     * Se però all'inizio la lista è vuota, devo fare attenzione ad aggiornare anche la coda col nuovo nodo.
     */
    public void aggiungiInTesta(int info) {
        Nodo nuovaTesta = new Nodo(info, this.testa);

        this.testa = nuovaTesta;

        if (this.lunghezza == 0) {
            this.coda = nuovaTesta;
        }

        this.lunghezza++;
    }



    //aggiunta elemento in coda alla lista
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



    public boolean rimuoviTesta() {
        //elimina la testa corrente della lista - se lista vuota restituisce false, altrimenti true
        if (this.lunghezza == 0) {
            return false;
        }

        this.testa = this.testa.getSuccessore();

        if (this.lunghezza == 1) {
            this.coda = null;
        }

        lunghezza--;

        return true;
    }



    public boolean rimuoviCoda() {
        if (this.lunghezza == 0) {
            return false;
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
        return true;
    }



    public boolean aggiungiInPosizione(int info, int pos) {
        //restituisce false se il valore di pos non è valido (0 <= pos <= lunghezza)
        if (pos < 0 || pos > this.lunghezza) {
            return false;
        }

        if (pos == 0) {
            aggiungiInTesta(info);
            return true;
        }
        if (pos == this.lunghezza) {
            aggiungiInCoda(info);
            return true;
        }

        //scandisco la lista
        int i = 1;  //la posizione successore di it
        Nodo it = this.testa;
        while (i < pos) {
            i++;
            it = it.getSuccessore();
        }
        //adesso it è l'elemento predecessore della posizione pos

        Nodo nuovoNodo = new Nodo(info, it.getSuccessore());
        it.setSuccessore(nuovoNodo);
        this.lunghezza++;
        return true;
    }



    public boolean modificaInPosizione(int info, int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos > this.lunghezza-1) {
            return false;
        }

        Nodo it = this.testa;
        int i = 0;
        while (i != pos) {
            it = it.getSuccessore();
            i++;
        }

        it.setInfo(info);
        return true;
    }



    public boolean rimuoviPosizione(int pos) {
        if (this.lunghezza == 0 || pos < 0 || pos > this.lunghezza-1) {
            return false;
        }

        if (pos == 0) {
            this.rimuoviTesta();
            return true;
        }
        if (pos == this.lunghezza-1) {
            this.rimuoviCoda();
            return true;
        }
        
        Nodo it = this.testa;
        int i = 0;
        while (i < pos-1) {
            it = it.getSuccessore();
            i++;
        }

        it.setSuccessore(it.getSuccessore().getSuccessore());
        lunghezza--;
        return true;
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
}
