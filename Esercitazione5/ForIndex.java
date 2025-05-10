package Esercitazione5;
import IO.*;
public class ForIndex {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        //for by index
        for (int el : array) {      //for el in array
            IO.println(el);
        }
    }
}
