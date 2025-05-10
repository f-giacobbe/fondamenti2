/* leggo dei numeri in input e li riscrivo in ordine inverso */

package Lezione8;

import IO.*;
public class ScriviInverso {
    public static void scriviInverso() {
        int n = IO.readInt("Quanti numeri devo leggere?: ");
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = IO.readInt("Digita valore in posizione "+i+": ");
        }

        for (int i=n-1; i>=0; i--) {
            IO.print(a[i] + " ");
        }
    }



    /* qui ho dovuto memorizzare in un array tutti i valori letti, ma proviamolo a fare con la ricorsione */
    //versione mia
    public static void scriviInversoRic(int n) {
        if (n==1) {
            IO.print((IO.readInt("Digita numero: ")) + " ");
            return;
        }
        int x = IO.readInt("Digita numero: ");
        scriviInversoRic(n-1);
        IO.print(x + " ");
        return;
    }




    //versione prof
    public static void leggiRic(int i) {
        int x = IO.readInt("Digita numero in posizione "+i+": ");

        if (i>1) {
            leggiRic(i-1);
        }

        IO.print(x + " ");
    }



    public static void scriviInversoRicProf() {
        int n = IO.readInt("Quanti numeri devo leggere? ");
        leggiRic(n);

    }



    public static void main(String[] args) {
        scriviInverso();
        scriviInversoRic(IO.readInt("Quanti numeri vuoi leggere?: "));
        scriviInversoRicProf();
    }
}
