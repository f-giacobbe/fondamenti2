package Simulazione1;
import IO.*;
public class Main {
    public static void main(String[] args) {
        int[] a = {12, 20, 8, 3, 2, 4, 2, -2};
        ListaConcatenataInt l = new ListaConcatenataInt(a);
        IO.println(l.contaTerne());
    }
}
