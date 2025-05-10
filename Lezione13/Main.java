package Lezione13;
import IO.*;
public class Main {
    public static void main(String[] args) {
        Persona p1 = Persona.leggiPersona();
        Persona p2 = Persona.leggiPersona();

        if (p1 == p2) {
            IO.println("Le due persone sono uguali");
        }
        else {
            IO.println("Le due persone NON sono uguali");
        }


        IO.println("Con il metodo equals definito da me:");
        if (p1.equals(p2)) {
            IO.println("Le due persone sono uguali");
        }
        else {
            IO.println("Le due persone NON sono uguali");
        }


        //ESERCIZI
        Persona p = new Persona(IO.readString("Nome: "), IO.readString("Cognome: "), 
                                IO.readInt("Età: "), null, null);
        Cliente c = new Cliente(IO.readString("Nome: "), IO.readString("Cognome: "), 
                                IO.readInt("Età: "), null);

        IO.println(p.equals(c));
        IO.println(c.equals(p));



        int[] nf1 = {1, 2, 3};
        int[] nf2 = {3, 2, 1};
        Cliente c1 = new Cliente("a", "b", 21, nf1);
        Cliente c2 = new Cliente("a", "b", 21, nf2);
        IO.println(c1.equals(c2));
    }
}
