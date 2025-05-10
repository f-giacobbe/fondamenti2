package Esercitazione9;

import IO.*;

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 3, 7, 13, 27, 53};

        ListaConcatenataInt l = new ListaConcatenataInt(a);

        IO.println(l.verificaCoppie());
    }
}
