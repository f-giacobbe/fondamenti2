/* leggere da input una serie di persone e generare un array contenente le persone */

package Lezione10;
import IO.*;
public class Esercizio19 {
    public static void main(String[] args) {
        Persona2[] arrayPersone = new Persona2[IO.readInt("Quante persone?: ")];

        for (int i=0; i<arrayPersone.length; i++) {
            arrayPersone[i] = new Persona2();
            arrayPersone[i].leggiPersona();
        }


        for (int i=0; i<arrayPersone.length; i++) {
            IO.println(arrayPersone[i]);
        }
    }
}
