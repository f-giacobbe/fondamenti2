/* prendere in input un array di persone e restituire l'indice di persona passata per argomento */


package Esercitazione4;
import IO.*;
public class IndicePersona {
    public static int indicePersona(Persona[] a, Persona p) {
        for (int i=0; i<a.length; i++) {
            if (ugualePersona(p, a[i])) {
                return i;
            }
        }

        return -1;
    }



    public static boolean ugualePersona(Persona p1, Persona p2) {
        if (!(p1.getNome().equals(p2.getNome()))) {
            return false;
        }

        if (!(p1.getCognome().equals(p2.getCognome()))) {
            return false;
        }

        if (p1.getEta() != p2.getEta()) {
            return false;
        }

        return true;
    }



    public static void main(String[] args) {
        Persona[] arrayPersone = new Persona[IO.readInt("Quante persone vuoi aggiungere all'array?: ")];

        for (int i=0; i<arrayPersone.length; i++) {
            arrayPersone[i] = new Persona();
            arrayPersone[i].leggiDaInput();
        }


        Persona x = new Persona("Francesco", "Giacobbe", 19);
        IO.println(indicePersona(arrayPersone, x));
    }

}
