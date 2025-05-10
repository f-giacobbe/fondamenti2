//CREAZIONE TIPI DEFINITI DALL'UTENTE

package Lezione10;
import IO.*;
public class Persona {      //seguiamo l'ordine: campi-costrutti-metodi
    //definisco i CAMPI della classe
    public String nome;
    public String cognome;
    public int eta;




    //posso definire delle operazioni di default, entrando nel COSTRUTTORE
    //verranno svolte dopo che viene creato l'oggetto
    public Persona() {
        this.cognome = "C";     //this indica un oggetto generico (posso anche ometterlo, ma meglio metterlo
                                //per chiarezza)
        eta = 18;
    }



    /* nel main posso creare l'oggetto persona passando direttamente i parametri */
    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }


    /* IMPORTANTE - definire o nessun costruttore (in questo caso java prenderà quello senza parametri
    e imposterà i valori di default) oppure definire sia quello senza parametri che quello con, altrimenti
    verrà dato errore se ad esempio definiamo solo un costruttore a tre parametri e nel main proveremo
    a creare un nuovo oggetto con un costruttore senza parametri */





    /* CREAZIONE METODI CLASSE - es. creiamo un metodo che restituisce una stringa data da nome e cognome */
    public String firma() {
        return this.nome + " " + this.cognome;
    }




    //metodo molto frequente - restituisce la conversione in stringa dell'oggetto corrente
    /* una volta creato il metodo chiamato esattamente toString, se io stampo l'oggetto nel main, NON verrà
     * più stampato l'indirizzo in memoria, ma verrà stampato il risultato di questo metodo
     */
    public String toString() {
        return "Nome: " + this.nome + "; " +
                "Cognome: " + this.cognome + "; " +
                "Età: " + this.eta;
    }





    //esempio metodo che legge da input i campi (invece che farlo nel main)
    public void leggiPersona() {
        this.nome = IO.readString("Scrivi nome: ");
        this.cognome = IO.readString("Scrivi cognome: ");
        this.eta = IO.readInt("Digita età: ");
    }




    /* Raramente i campi vengono lasciati public, invece frequentemente i campi vengono messi private
     * e per manipolare i campi degli oggetti dò io all'utente dei metodi per farlo (GETTERS AND SETTERS)
     * 
     * Mettendo solo getters, ad esempio, posso creare classi immutabili
     */
    //esempio
    private int sesso;  //0 se maschio 1 se femmina

    //GETTER
    public int getSesso() {
        return this.sesso;
    }
    //SETTER
    public void setSesso(int sesso) {
        if (sesso == 0 || sesso == 1) {
            this.sesso = sesso;
        }
    }



    public Object getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }



    public Object getCognome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCognome'");
    }



    public Object getEta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEta'");
    }
}
