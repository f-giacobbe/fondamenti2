package Lezione19;

public class MergeSort {
    /**
     * Ordina in senso crescente l'array
     * @param v Il vettore da ordinare
     */
    public static void mergeSort(int[] v) {
        if (v == null || v.length <= 1) {
            return;
        }

        mergeSort(v, 0, v.length-1);
    }

    private static void mergeSort(int[] v, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(v, low, mid);
        mergeSort(v, mid+1, high);
        merge(v, low, mid, high);

        return;
    }

    private static void merge(int[] v, int low, int mid, int high) {
        //crea due sottoarray temporanei
        int[] leftArray = new int[mid-low+1];
        int[] rightArray = new int[high-mid];

        //copio le due porzioni
        for (int i=0; i<leftArray.length; i++) {
            leftArray[i] = v[low+i];
        }
        for (int i=0; i<rightArray.length; i++) {
            rightArray[i] = v[mid+1+i];
        }

        //creo i due iteratori con i quali scandire leftArray e rightArray
        int leftIndex = 0;
        int rightIndex = 0;

        //copio in modo ordinato leftArray e rightArray su v
        for (int i=low; i<=high; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    v[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else{
                    v[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else {  //ho finito uno dei due array
                if (leftIndex < leftArray.length) {
                    v[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else if (rightIndex < rightArray.length) {
                    v[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
        }

        return;
    }
}