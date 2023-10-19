import cliente.Cliente;
import database.Database;
import veicoli.Bicicletta;
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

    public void affittaVeicolo(Veicolo veicolo, int tempo){
        if(tempo<=5){
            System.out.println("Il veicolo deve essere affittato per più di 5 minuti");
            return;
        }
        if(veicolo instanceof Bicicletta){
            veicolo.booked();
        }
        else {
            veicolo.updateFuel(veicolo.getLivelloCarburante() - (tempo / 3));
            veicolo.booked();
        }
    }


    // metodo per cercare veicoli disponibili
    // ricerca(...)




    public void lasciaVeicolo(Veicolo veicolo){
      if(veicolo.getLivelloCarburante()<20)
          ricaricaVeicolo(veicolo);


          veicolo.free();

    }

    public void ricaricaVeicolo(Veicolo veicolo){
        veicolo.updateFuel(100);
    }


}
