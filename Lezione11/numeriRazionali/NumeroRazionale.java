// CREAZIONE PACKAGE (una cartella contenente tutte le classi opportune per quel package)

package Lezione11.numeriRazionali;
public class NumeroRazionale {
    private int numeratore;
    private int denominatore;

    public NumeroRazionale() {
        this.numeratore = 1;
        this.denominatore = 1;
    }

    public NumeroRazionale(int n, int d) {
        if (d != 0) {
            this.numeratore = n;
            this.denominatore = d;
        }

        this.mettiInFormaStandard();
        this.minimiTermini();
    }


    public int getNumeratore() {
        return numeratore;
    }


    public int getDenominatore() {
        return denominatore;
    }

    //rendo la classe immutabile, decidendo di non mettere i setters
    
    public String toString() {
        return this.numeratore + "/" + this.denominatore;
    }



    public NumeroRazionale somma(NumeroRazionale nr2) {
        NumeroRazionale res = new NumeroRazionale();

        res.denominatore = mcm(this.denominatore, nr2.denominatore);
        res.numeratore = (res.denominatore * this.numeratore)/this.denominatore + (res.denominatore * nr2.numeratore)/nr2.denominatore;

        res.minimiTermini();
        res.mettiInFormaStandard();
        return res;
    }



    public NumeroRazionale sommaSenzaMcm(NumeroRazionale nr2) {
        NumeroRazionale res = new NumeroRazionale();

        res.denominatore = this.denominatore * nr2.denominatore;
        res.numeratore = nr2.denominatore * this.numeratore + this.denominatore * nr2.numeratore;

        res.minimiTermini();
        res.mettiInFormaStandard();
        return res;
    }



    public static int mcm(int n1, int n2) {
        if (n1 == n2) {
            return n1;
        }

        int res = (abs(n1) > abs(n2)) ? abs(n1) : abs(n2);  //il maggiore tra n1 ed n2

        boolean multiploDiEntrambi = false;
        while (!multiploDiEntrambi) {
            if ((res % n1 == 0) && (res % n2 == 0)) {
                multiploDiEntrambi = true;;
            }

            else {
                res += (abs(n1) > abs(n2)) ? abs(n1) : abs(n2);
            }

        }

        return res;
    }



    public void minimiTermini() {
        if (this.numeratore == this.denominatore) {
            this.numeratore = 1;
            this.denominatore = 1;

            return;
        }

        // 0/x
        if (this.numeratore == 0) {
            this.denominatore = 1;
            return;
        }

        int mcd = mcd(this.numeratore, this.denominatore);

        this.numeratore = this.numeratore / mcd;
        this.denominatore = this.denominatore / mcd;
    }
    


    public static int mcd(int n1, int n2) {
        if (n1 == n2) {
            return n1;
        }

        if (n1 == 0) {
            return n2;
        }
        else if (n2 == 0) {
            return n1;
        }


        int res = (abs(n1) < abs(n2)) ? abs(n1) : abs(n2);

        boolean divisoreDiEntrambi = false;
        while(!divisoreDiEntrambi && res > 1) {
            if ((n1 % res == 0) && (n2 % res == 0)){
                divisoreDiEntrambi = true;
            }
            else {
                res--;
            }
        }

        return res;
    }



    public static int mcdEuclide(int a, int b) {
        /* se a è multiplo di b, l'MCD è b      a > b
         * altrimenti, è il MCD tra b (il più piccolo) e il resto della divisione tra a e b
         */

        if (a % b == 0) {
            return b;
        }
        return mcdEuclide(b, (a % b));
    }



    public void mettiInFormaStandard() {
        //--
        if (this.numeratore < 0 && this.denominatore < 0) {
            this.numeratore = invertiSegno(this.numeratore);
            this.denominatore = invertiSegno(this.denominatore);
        }

        //+-
        else if (this.numeratore >= 0 && this.denominatore < 0) {
            this.numeratore = invertiSegno(this.numeratore);
            this.denominatore = invertiSegno(this.denominatore);
        }

        return;
    }



    public static int invertiSegno(int n) {
        return n * -1;
    }



    public static int abs(int n) {
        if (n >= 0) {
            return n;
        }
        return n * -1;
    }



    public NumeroRazionale prodotto(NumeroRazionale nr2) {
        NumeroRazionale res = new NumeroRazionale();

        res.numeratore = this.numeratore * nr2.numeratore;
        res.denominatore = this.denominatore * nr2.denominatore;

        res.minimiTermini();
        res.mettiInFormaStandard();
        return res;
    }



    public NumeroRazionale rapporto(NumeroRazionale nr2) {
        if (nr2.numeratore == 0) {
            return null;
        }

        NumeroRazionale nr2Inv = new NumeroRazionale(nr2.denominatore, nr2.numeratore);
        
        NumeroRazionale res = this.prodotto(nr2Inv);
        return res;
    }



    public NumeroRazionale inverti() {
        if (this.numeratore == 0) {
            return null;
        }

        NumeroRazionale res = new NumeroRazionale(this.denominatore, this.numeratore);
        return res;
    }
}
