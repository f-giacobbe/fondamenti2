/* Leggere da input una serie di persone (chiedere quanto lunga) e alla fine scrivere su output i dati 
    della persona con l'età massima */

package Lezione10;
import IO.*;
public class Esercizio18 {
    public static void main(String[] args) {
        Persona2 personaEtaMax = new Persona2();
        int n = IO.readInt("Quante persone?: ");


        Persona2 personaGenerica = new Persona2();
        for (int i=0; i<n; i++) {
            personaGenerica.leggiPersona();
            
            if (personaGenerica.getEta() > personaEtaMax.getEta()) {
                personaEtaMax.setNome(personaGenerica.getNome());
                personaEtaMax.setCognome(personaGenerica.getCognome());
                personaEtaMax.setEta(personaGenerica.getEta());
            }
        }

        IO.println("I dati della persona avente età massima sono i seguenti: " + personaEtaMax);


        IO.println(personaEtaMassima());
    }



    //oppure con array
    public static Persona2 personaEtaMassima() {
        Persona2[] arrayPersone = new Persona2[IO.readInt("Quante persone?: ")];

        Persona2 persona = new Persona2();
        for (int i=0; i<arrayPersone.length; i++) {
            persona.leggiPersona();

            arrayPersone[i] = new Persona2(persona.getNome(), persona.getCognome(), persona.getEta());
        }

        Persona2 personaEtaMax = new Persona2();
        for (int i=0; i<arrayPersone.length; i++) {
            if (arrayPersone[i].getEta() > personaEtaMax.getEta()) {
                personaEtaMax.setNome(arrayPersone[i].getNome());
                personaEtaMax.setCognome(arrayPersone[i].getCognome());
                personaEtaMax.setEta(arrayPersone[i].getEta());
            }
        }

        return personaEtaMax;
    }
}
