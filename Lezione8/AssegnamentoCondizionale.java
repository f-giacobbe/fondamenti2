package Lezione8;
import IO.*;
public class AssegnamentoCondizionale {

    public static void main(String[] args) {
        //assegnamento condizionale
        int n = IO.readInt("");
        int x = n==1?0:1;   //se n==1 allora 0; altrimenti 1

        IO.println(x);
    }
}
