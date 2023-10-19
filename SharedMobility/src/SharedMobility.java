import cliente.Cliente;
import database.Database;
import veicoli.Veicolo;

public class SharedMobility {
    private Database db;

    public SharedMobility() {
        db = new Database();
    }

    // metodo per registrare utente
    // clientSignUp()

    public void clientSignUp(Cliente cliente){
        db.putCliente(cliente);

    }

    public void affittaVeicolo(Veicolo veicolo){
        veicolo.booked();
        //Se avessimo solamente un dato che appartiene al veicolo andrebbe cercato il veicolo nel database e poi verrebbe aggiornato da lì
    }


    // metodo per cercare veicoli disponibili
    // ricerca(...)

    // metodo per affittare un veicolo (almeno 5 min)
    //affittaVeicolo(Veicolo veicolo)

    // metodo per lasciare un veicolo
    // lasciaVeicolo(Veicolo veicolo)
    public void lasciaVeicolo(Veicolo veicolo){
        veicolo.free();
    }

    public void ricaricaVeicolo(Veicolo veicolo){
        veicolo.updateFuel(100);
    }

    // metodo per ricaricare veicolo
    // ricaricaVeicolo(Veicolo veicolo)
}
