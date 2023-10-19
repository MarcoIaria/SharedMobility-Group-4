package database;

import cliente.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import veicoli.*;

import java.util.ArrayList;
import java.util.LinkedList;

@Getter @Setter
public class Database {

    private LinkedList<Cliente> clienti;
    private ArrayList<Automobile> automobili;
    private ArrayList<Scooter> scooters;
    private ArrayList<MonopattinoElettrico> monopattiniElettrici;
    private ArrayList<Furgoncino> furgoncini;
    private ArrayList<Bicicletta> biciclette;

    public Database() {
        clienti = new LinkedList<>();
        automobili = new ArrayList<>();
        scooters = new ArrayList<>();
        monopattiniElettrici = new ArrayList<>();
        furgoncini = new ArrayList<>();
        biciclette = new ArrayList<>();
    }

    public void putVeicolo(Veicolo veicolo) {
        try {
            if (veicolo instanceof Automobile) {
                automobili.add((Automobile) veicolo);
            } else if (veicolo instanceof Scooter) {
                scooters.add((Scooter) veicolo);
            } else if (veicolo instanceof MonopattinoElettrico) {
                monopattiniElettrici.add((MonopattinoElettrico) veicolo);
            } else if (veicolo instanceof Furgoncino) {
                furgoncini.add((Furgoncino) veicolo);
            } else if (veicolo instanceof Bicicletta) {
                biciclette.add((Bicicletta) veicolo);
            }
        } catch (NullPointerException e){
            System.out.println("Invalid vehicle.");
            System.out.println(e.getMessage());
        }
    }

    public void putCliente(Cliente cliente) {
        try {
            clienti.add(cliente);
        } catch (NullPointerException e){
            System.out.println("Invalid user.");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Database{" +
                "clienti=" + clienti +
                ", automobili=" + automobili +
                ", scooters=" + scooters +
                ", monopattiniElettrici=" + monopattiniElettrici +
                ", furgoncini=" + furgoncini +
                ", biciclette=" + biciclette +
                '}';
    }

    // filtri
    // idFilter(int id)
    // LocationFilter(String posizione)

}
