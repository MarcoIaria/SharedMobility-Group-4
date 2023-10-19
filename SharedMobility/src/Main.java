import cliente.Cliente;
import database.Database;
import shared_mobility.SharedMobility.src.Patenti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Patenti> patenti = new ArrayList<>();
        patenti.add(Patenti.A);
        Cliente cliente = new Cliente("Marco", "Rossi", new Date(1988, 04, 12), "", patenti, true);

        System.out.println(cliente.toString());

        Database db = new Database();
        db.putCliente(cliente);
        System.out.println(db.toString());
    }
}
