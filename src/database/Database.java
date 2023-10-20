package database;

import Exceptions.VehicleNotFound;
import lombok.Getter;
import lombok.Setter;
import veicoli.*;
import java.util.ArrayList;

@Getter @Setter
public class Database {

    private ArrayList<Automobile> automobili;
    private ArrayList<Scooter> scooters;
    private ArrayList<MonopattinoElettrico> monopattiniElettrici;
    private ArrayList<Furgoncino> furgoncini;
    private ArrayList<Bicicletta> biciclette;

    public Database() {
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
    @Override
    public String toString() {
        return  "automobili=" + automobili + "\n" +
                "scooters=" + scooters + "\n" +
                "monopattiniElettrici=" + monopattiniElettrici + "\n" +
                "furgoncini=" + furgoncini + "\n" +
                "biciclette=" + biciclette;
    }

    // filtri
    public Veicolo idFilter(int id) throws VehicleNotFound{
         for (Automobile automobile : automobili) {
             if (automobile.getIdVeicolo() == id) {
                 if (automobile.isBooked()) return null;
                 return automobile;
             }
         }
         for (Scooter scooter : scooters) {
             if (scooter.getIdVeicolo() == id) {
                 if (scooter.isBooked()) return null;
                 return scooter;
             }
         }
         for (MonopattinoElettrico monopattinoElettrico : monopattiniElettrici) {
             if (monopattinoElettrico.getIdVeicolo() == id) {
                 if (monopattinoElettrico.isBooked()) return null;
                 return monopattinoElettrico;
             }
         }
         for (Furgoncino furgoncino : furgoncini) {
             if (furgoncino.getIdVeicolo() == id) {
                 if (furgoncino.isBooked()) return null;
                 return furgoncino;
             }
         }
         for (Bicicletta bicicletta : biciclette) {
             if (bicicletta.getIdVeicolo() == id) {
                 if (bicicletta.isBooked()) return null;
                 return bicicletta;
             }
         }
         throw new VehicleNotFound();
     }

    public ArrayList<Veicolo> availableVehicles() {
        ArrayList<Veicolo> veicoliDisponibili = new ArrayList<>();

        for (Automobile automobile : automobili) {
            if (!automobile.isBooked()) veicoliDisponibili.add(automobile);
        }
        for (Scooter scooter : scooters) {
            if (!scooter.isBooked()) veicoliDisponibili.add(scooter);
        }
        for (MonopattinoElettrico monopattinoElettrico : monopattiniElettrici) {
            if (!monopattinoElettrico.isBooked()) veicoliDisponibili.add(monopattinoElettrico);
        }
        for (Furgoncino furgoncino : furgoncini) {
            if (!furgoncino.isBooked()) veicoliDisponibili.add(furgoncino);
        }
        for (Bicicletta bicicletta : biciclette) {
            if (!bicicletta.isBooked()) veicoliDisponibili.add(bicicletta);
        }
        return veicoliDisponibili;
    }

    public ArrayList<Veicolo> locationFilter(String location) throws VehicleNotFound{
        ArrayList<Veicolo> veicoliDisponibili = availableVehicles();
        ArrayList<Veicolo> veicoliByLocation = new ArrayList<>();

        location = location.toLowerCase();

        for (Veicolo veicolo : veicoliDisponibili) {
            if (veicolo.getPosizione().equals(location)) veicoliByLocation.add(veicolo);
        }

        if (veicoliByLocation.isEmpty()) throw new VehicleNotFound();
        return veicoliByLocation;
    }

    public ArrayList<Veicolo> fuelFilter(String carburante) throws VehicleNotFound{
        ArrayList<Veicolo> veicoliDisponibili = availableVehicles();
        ArrayList<Veicolo> veicoliByCarburante = new ArrayList<>();

        carburante = carburante.toLowerCase();

        for (Veicolo veicolo : veicoliDisponibili) {
            if (veicolo.getTipoCarburante().equals(carburante)) veicoliByCarburante.add(veicolo);
        }

        if (veicoliByCarburante.isEmpty()) throw new VehicleNotFound();
        return veicoliByCarburante;
    }

    public ArrayList<Veicolo> priceFilter(double rangeMin, double rangeMax) throws VehicleNotFound{
        ArrayList<Veicolo> veicoliDisponibili = availableVehicles();
        ArrayList<Veicolo> veicoliByPrice = new ArrayList<>();

        for (Veicolo veicolo : veicoliDisponibili) {
            if (veicolo.getTariffa() >= rangeMin && veicolo.getTariffa() <= rangeMax) veicoliByPrice.add(veicolo);
        }

        if (veicoliByPrice.isEmpty()) throw new VehicleNotFound();
        return veicoliByPrice;
    }

}
