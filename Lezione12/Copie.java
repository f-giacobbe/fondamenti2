//PRIMA DOMANDA D'ESAME

package Lezione12;
import IO.*;
public class Copie {
    public static void main(String[] args) {
        //se ho due interi
        int a = 5;
        int b = 6;
        //e voglio fare lo swap
        int temp = a;
        a=b;
        b = temp;




        //ma NON è così quando si ha a che fare con degli oggetti
        Persona p = new Persona("A", "B", 20, new NumeroTelefonico("1", "1"), new int[] {1, 2, 3});

        Persona q = p;      //questo è solo un'ALIASING (NON UNA COPIA) -- copio solo l'indirizzo di memoria
        /* ciò comporta che se modifico uno, modifico anche l'altro */

        p.setEta(21);
        IO.println(p);
        IO.println(q); //viene modificata anche l'età di q
        IO.println("");



        //come si fa quindi a creare una VERA copia?
        Persona s0 = new Persona(p.getNome(), p.getCognome(), p.getEta(), p.getNumeroTelefonico(), p.getNumeriFortunati());
            //gli passo manualmente i singoli campi
        /* il nome e il cognome, pur essendo stringhe, non causano problema di aliasing in quanto, se vado
         * a cambiare il nome di p viene creata una NUOVA stringa con un NUOVO indirizzo
         */
        p.setNome("C");
        IO.println(p);
        IO.println(q);
        IO.println(s0);
        IO.println("");


        /* in realtà però non viene fatta con i getters la copia, per cui viene definito il cosiddetto
         * "COSTRUTTORE PER COPIA" all'interno della classe persona
         * << andiamo alla classe Persona
         */
        Persona s = new Persona(s0);



        //PROBLEMA NUMERO TELEFONICO
        p.getNumeroTelefonico().setPrefisso("1000");
        
        IO.println(p);
        IO.println(s);
        //siccome s punta allo stesso oggetto NumeroTelefonico, anche s risente della modifica
        //ciò accade perché abbiamo reso NumeroTelefonico MUTABILE (posso accedere ai campi tramite set)
        IO.println("");



        //usando il deep copy   (lascia stare n:0)
        Persona z = new Persona(p, 0);


        p.getNumeroTelefonico().setPrefisso("2000");

        IO.println(p);
        IO.println(z);

        IO.println("");



        //per quanto riguarda i numeri fortunati
        
        //con lo shallow copy
        s = new Persona(p);

        p.getNumeriFortunati()[0] = 8;

        p.stampaNumeriFortunati();
        s.stampaNumeriFortunati();      //viene modificato anche s


        p.getNumeriFortunati()[0] = 1;
        //con il deep copy
        s = new Persona(p, 0);

        p.getNumeriFortunati()[0] = 7;

        p.stampaNumeriFortunati();
        s.stampaNumeriFortunati();
    }
}
