package Lezione8;

import IO.*;
public class Ricorsione_fattoriale {
    //RICORSIONE
    public static long fact(long n) {
        if (n==0 || n==1) {
            return 1;
        }
        return n * fact(n-1);
    }



    public static void main(String[] args) {
        IO.println(fact(4));
    }
}
