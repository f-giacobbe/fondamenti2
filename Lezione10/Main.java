package Lezione10;
import IO.*;
public class Main {
    public static void main(String[] args) {
        Persona p = new Persona();  /* Persona() è il COSTRUTTORE - costruisce dentro l'heap
                                        una variabile per ogni variabile definita in Pesona */
        //p è ora detto oggetto persona

        IO.println(p);  //stampa l'indirizzo di memoria
        IO.println(p.cognome + p.nome + p.eta); //restituisce i valori di default che ho impostato


        p.cognome = "Alighieri";
        p.nome = "Dante";
        p.eta = 40;

        IO.println(p.nome + " " + p.cognome + " " + p.eta);

        /* in memoria ciò che avviene è analogo a quanto avviene con gli array */




        //creo un oggetto persona direttamente tramite i parametri del costruttore
        Persona q = new Persona("Ciccio", "Giacobbe", 19);
        IO.println(q.nome + q.cognome + q.eta);



        //uso metodo classe
        IO.println(q.firma());

        //uso metodo toString - ANCHE IN MODO IMPLICITO
        IO.println(q.toString());
        IO.println(q);


        //uso metodo leggiPersona
        Persona k = new Persona();
        k.leggiPersona();
        IO.println(k);

        k.setSesso(0);
        IO.println("Sesso: " + k.getSesso());
    }
}
