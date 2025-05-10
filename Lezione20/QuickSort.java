package Lezione20;

public class QuickSort {
    public static void quickSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        quickSort(a, 0, a.length-1);
        return;
    }

    private static void quickSort(int[] a, int low, int high) {
        int pivotIndex = partition(a, low, high);
        /* adesso oltre a conoscere l'indice del pivot, alla sua sinistra avremo solo elementi minori di
         * esso, mentre alla sua destra solo elementi maggiori, quindi non ci basta che ordinare le due parti
         */

        if (low < pivotIndex-1) {
            quickSort(a, low, pivotIndex-1);
        }

        if (pivotIndex+1 < high) {
            quickSort(a, pivotIndex+1, high);
        }

        return;
    }

    /**
     * Effettua la partizione di una porzione dell'array, spostando sulla sinistra gli elementi minori o
     * uguali del valore pivot, e sulla destra gli elementi maggiori o uguali del valore pivot.
     * Utilizza come pivot il valore in posizione mediana della porzione passata come input
     * @param a L'array contenente il sottoarray da partizionare
     * @param i L'estremo sinistro del sottoarray
     * @param j L'estremo destro del sottoarray
     * @return La posizione assunta dal valore pivot al termine del partizionamento
     */
    private static int partition(int[] a, int i, int j) {
        int tmp;
        int pivot = a[(i+j)/2];

        while (i <= j) {
            while (a[i] < pivot)    //trova numero maggiore del pivot
                i++;

            while (a[j] > pivot)    //trova numero minore del pivot
                j--;

            if (i <= j) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }
}
