import Exceptions.VehicleNotFound;
import cliente.Cliente;
import database.Database;
import shared_mobility.SharedMobility.src.Patenti;
import veicoli.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws VehicleNotFound {
        List<Patenti> patenti = new ArrayList<>();
        patenti.add(Patenti.A);

        Database db = new Database();
        Automobile veicolo1 = new Automobile("ABC", "Benzina", 1, "Roma");
        Automobile veicolo2 = new Automobile("ABC", "Metano", 2, "Milano");
        Automobile veicolo3 = new Automobile("ABC", "Diesel", 0.4, "Torino");
        Automobile veicolo4 = new Automobile("ABC", "Benzina", 1, "Roma");
        db.putVeicolo(veicolo1);
        db.putVeicolo(veicolo2);
        db.putVeicolo(veicolo3);
        db.putVeicolo(veicolo4);
        Bicicletta veicolo5 = new Bicicletta(0.1, "Pisa");
        Furgoncino veicolo6 = new Furgoncino("ABC", "Metano", 5, "Milano");
        MonopattinoElettrico veicolo7 = new MonopattinoElettrico("CDF",0.1, "Pisa");
        Scooter veicolo8 = new Scooter("ABC", "Benzina", 0.5, "Milano");
        db.putVeicolo(veicolo5);
        db.putVeicolo(veicolo6);
        db.putVeicolo(veicolo7);
        db.putVeicolo(veicolo8);

        System.out.println(db);
        SharedMobility gestionale = new SharedMobility(db);
        Cliente cliente = new Cliente("Marco", "Rossi", new Date(1988, 04, 12), "Co", patenti, true);
        Cliente cliente2 = new Cliente("Marco", "Rossi", new Date(1988, 04, 12), "BS6", patenti, true);
        gestionale.clientSignUp(cliente);
        gestionale.clientSignUp(cliente2);
//        gestionale.search(0);
//        gestionale.affittaVeicolo(veicolo1, 50);
//        gestionale.lasciaVeicolo(veicolo1);
//        gestionale.search(1);
//        gestionale.search(2);
//        gestionale.search(3);

    }
}
