package Lezione11;
import Lezione11.numeriRazionali.*;
import IO.*;
public class PackageNumeriRazionali {
    public static void main(String[] args) {
        NumeroRazionale n1 = new NumeroRazionale(4, -10);
        NumeroRazionale n2 = new NumeroRazionale(36, -270);

        IO.println(n1.somma(n2));
        IO.println(n2);
    }
}
