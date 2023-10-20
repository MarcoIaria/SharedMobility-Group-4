import Exceptions.VehicleNotFound;
import cliente.Cliente;
import database.Database;
import veicoli.Bicicletta;
import veicoli.Veicolo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SharedMobility {
    Scanner sc = new Scanner(System.in);
    private Database db;

    public SharedMobility() {
        db = new Database();
    }

    public SharedMobility(Database db) {
        this.db = db;
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
    public void search(int i) throws VehicleNotFound {
        if (i == 0 ) {
            if (db.idFilter(0) == null){
                System.out.println("Veicolo Occupato");
                return;
            }
            System.out.print("Inserisci ID Veicolo: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println(db.idFilter(id));
            return;
        }
        if (db.availableVehicles() == null){
            System.out.println("Nessun veicolo disponibile");
            return;
        }
        switch (i){
            case 1:
                System.out.print("Inserisci posizione Veicolo: ");
                String p = sc.nextLine();
                System.out.println(db.locationFilter(p));
                break;
            case 2:
                System.out.print("Inserisci tipo carburante: ");
                String c = sc.nextLine();
                System.out.println(db.fuelFilter(c));
                break;
            case 3:
                System.out.print("Inserisci range di prezzo (Min, Max): ");
                double min = (Double.parseDouble(sc.nextLine())) ;
                double max = (Double.parseDouble(sc.nextLine())) ;
                System.out.println(db.priceFilter(min   , max));
                break;
        }
    }



    public void lasciaVeicolo(Veicolo veicolo){
      if(veicolo.getLivelloCarburante()<20)
          ricaricaVeicolo(veicolo);


      veicolo.free();

    }

    public void ricaricaVeicolo(Veicolo veicolo){
        veicolo.updateFuel(100);
    }


}
