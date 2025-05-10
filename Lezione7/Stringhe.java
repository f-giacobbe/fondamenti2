package Lezione7;

import IO.*;
public class Stringhe {
    public static void main(String[] args) {
        //con la MAIUSCOLA
        String s = "Ciao";
        IO.println(s);

        String s1 = " a tutti";
        String s2 = s + s1;

        IO.println(s2);


        String s3 = "Ciao a tutti";

        /* apparentemente s2 ed s3 sono uguali, però: */
        IO.println(s2 == s3);   //-> false
        /* perché chiaramente hanno indirizzi diversi */




        //FUNZIONI PROPRIE STRINGA
        /* ATTENZIONE - nessuna di queste funzioni modifica le stringhe, in quanto immutabili, al massimo
         * vengono restituite nuove stringhe
         */

        /* Come faccio allora a verificare se due stringhe sono uguali? Uso "EQUALS" */
        IO.println(s2.equals(s3));  //-> true



        /* allo stesso modo per accedere a un carattere della stringa */
        IO.println(s2.charAt(0));   //-> C



        //verifica se stringa contiene sequenza di caratteri
        IO.println(s3.contains("ao"));  //-> true


        //funzione REPLACE - che NON modifica, ma restituisce una nuova stringa, per cui l'assegnamento
        s = s.replace("C", "Z");
        IO.println(s);






        /* posso farlo, in quanto concatenazione tra due stringhe, ma in generale le stringhe sono
        *  immutabili */
        s = s + "xyz";  //viene creata di fatto una NUOVA stringa
        IO.println(s);

        /* dunque è impossibile modificare una stringa senza alterarne l'indirizzo in memoria, dunque
         * senza creare una nuova stringa di fatto
         */


        String stringa = "ciao";
        IO.println(stringa.substring(1, 3));
    }
}
