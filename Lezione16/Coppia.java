/* classe di coppia di elementi, di cui però non conosco a priori il tipo, per cui ne indico uno generico */

package Lezione16;
                    //scrivendo extends Comparable rendo la Classe accessibile solo alle classi con il compareTo
@SuppressWarnings("rawtypes")
public class Coppia<T extends Comparable> {
    private T elem1;
    private T elem2;



    public Coppia() {
        this.elem1 = null;
        this.elem2 = null;
    }



    public String toString() {
        return "Elem1: " + this.elem1 + "; Elem2: " + this.elem2;
    }



    public T getElem1() {
        return elem1;
    }



    public void setElem1(T elem1) {
        this.elem1 = elem1;
    }



    public T getElem2() {
        return elem2;
    }



    public void setElem2(T elem2) {
        this.elem2 = elem2;
    }
    


    //metodo che funziona su array di tipo generico
    /* nei metodi statici occorre <T>
     * in più l'extends Comparable suggerisce a Java che la classe T ha il compareTo
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable> Coppia<T> minMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        Coppia<T> res = new Coppia<>();
        res.elem1 = array[0];
        res.elem2 = array[0];

        for (int i=1; i<array.length; i++) {
            if (array[i].compareTo(res.elem1) < 0) {            //uso il compareTo
                res.elem1 = array[i];
            }
            else if (array[i].compareTo(res.elem2) > 1) {
                res.elem2 = array[i];
            }
        }

        return res;
    }
}
