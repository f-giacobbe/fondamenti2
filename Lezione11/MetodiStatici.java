package Lezione11;
import IO.*;
public class MetodiStatici {
    public static void main(String[] args) {
        NumeroTelefonico nt = new NumeroTelefonico("0984", "43294");
        Persona p = new Persona("Filippo", "Furfaro", 48, nt);

        IO.println(p);
        IO.println(p.getNome());
        //il parametro p è implicito in quanto chiamato come prefisso di getNome() - METODO DINAMICO
        //non posso evocarli se non esiste l'oggetto p in questo caso
        //le occorrenze di "this" all'interno del metodo vengono sostituite in questo caso con "p"


        /* ma è anche possibile creare metodi in cui va passato come parametro - METODO STATICO 
         * non richiede un oggetto su cui essere invocato
         * usa come prefisso il nome della classe
         * 
         * può essere usato anche se non ci sono oggetti della classe (anche se in questo caso lo prende
         * come parametro)
         */
        Persona.stampa(p);  //STATICO
        p.stampa(); //DINAMICO


        /* In generale, i getters e setters vengono scritti in forma dinamica, mentre tutti gli altri
         * possiamo scriverli come ci piace. Ma in generale, se ad esempio creiamo una classe intesa come
         * "collezione di metodi" (es. IO), conviene farli statici. Mentre se abbiamo una classe intesa
         * come oggetto (es. Persona), conviene farli dinamici, in quanto la maggior parte dei metodi
         * andranno a riguardare l'oggetto di quella classe
         */





        Persona q = Persona.creaPersona();
        IO.println(q);



        //comparazione statica e dinamica
        Persona p1 = new Persona("A", "B", 13, null);
        Persona p2 = new Persona ("C", "D", 15, new NumeroTelefonico("0984", "123"));
        IO.println(p1.etaMinore(p2));
        IO.println(Persona.etaMinore(p1, p2));
    }
}
