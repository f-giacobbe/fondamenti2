package Lezione20;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low >= high)
            return;

        int pivotIndex = partition(a, low, high);
        /* adesso oltre a conoscere l'indice del pivot, alla sua sinistra avremo solo elementi minori di
         * esso, mentre alla sua destra solo elementi maggiori, quindi non ci basta che ordinare le due parti
         */

        quickSort(a, low, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, high);
    }

    /**
     * Effettua la partizione di una porzione dell'array, spostando sulla sinistra gli elementi minori o
     * uguali del valore pivot, e sulla destra gli elementi maggiori o uguali del valore pivot.
     * Utilizza come pivot il valore in posizione mediana della porzione passata come input
     * @param a L'array contenente il sottoarray da partizionare
     * @param low L'estremo sinistro del sottoarray
     * @param high L'estremo destro del sottoarray
     * @return La posizione assunta dal valore pivot al termine del partizionamento
     */
    private static int partition(int[] a, int low, int high) {
        int tmp;
        int mid = (low + high) / 2;
        int pivot = a[mid];

        // Swap tra pivot e ultimo elemento
        tmp = a[mid];
        a[mid] = a[high];
        a[high] = tmp;

        int i = low;
        int j = high - 1;

        while (i <= j) {
            while (i <= j && a[i] < pivot)    //trova numero maggiore del pivot
                i++;

            while (i <= j && a[j] > pivot)    //trova numero minore del pivot
                j--;

            if (i <= j) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }

        tmp = a[i];
        a[i] = a[high];
        a[high] = tmp;

        return i;
    }
}
