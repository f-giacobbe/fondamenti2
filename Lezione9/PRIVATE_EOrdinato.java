/* preso un array in input, verificare se è ordinato (ricorsivo) */
// + signature PRIVATE

package Lezione9;

import IO.*;
public class PRIVATE_EOrdinato {
    //prof
    private static boolean eOrdinatoProf(int[] a, boolean crescente, int i) {
        if (i == a.length-1) {
            return true;
        }

        if (crescente && a[i] > a[i+1]) {
            return false;
        }

        if (!crescente && a[i] < a[i+1]) {
            return false;
        }

        return eOrdinatoProf(a, crescente, i+1);
    }



    //mio
    private static boolean eOrdinato(int[] a, boolean crescente, int i) {
        if (crescente) {
            if (i<a.length-1) {
                if (a[i] > a[i+1]) {
                    return false;
                }
                return eOrdinato(a, crescente, i+1);
            }
            else {
                return true;
            }
        }
        else {  //decrescente
            if (i<a.length-1) {
                if (a[i] < a[i+1]) {
                    return false;
                }
                return eOrdinato(a, crescente, i+1);
            }
            else {
                return true;
            }
        }
    }



    public static boolean eOrdinato(int[] a, boolean crescente) {
        return eOrdinato(a, crescente, 0);
    }



    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3};
        IO.println(eOrdinato(a, false));
        IO.println(eOrdinatoProf(a, false, 0));
    }
}
