
import Exceptions.VehicleBooked;
import Exceptions.VehicleNotFound;
import cliente.Cliente;
import database.Database;
import shared_mobility.SharedMobility.src.Patenti;
import veicoli.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Patenti> patenti = new ArrayList<>();
        patenti.add(Patenti.A);
        SharedMobility gestionale = new SharedMobility();
        Cliente cliente = new Cliente("Marco", "Rossi", new Date(1988, 4, 12), "Co", patenti, true);
        Cliente cliente2 = new Cliente("Marco", "Rossi", new Date(1988, 4, 12), "BS6", patenti, true);
//        gestionale.search(0);
        try {
            gestionale.affittaVeicoloByID(1, 50, cliente);
            gestionale.affittaVeicoloByID(2, 4, cliente2);
            gestionale.affittaVeicoloByID(7, 15, cliente2);
            gestionale.affittaVeicoloByID(7, 15, cliente2);
        }catch (VehicleNotFound | VehicleBooked e){
            System.out.println(e.getMessage());
        }
//        gestionale.search(1);
//        gestionale.search(2);
//        gestionale.search(3);

    }
}
