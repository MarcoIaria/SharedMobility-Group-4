import Exceptions.VehicleBooked;
import Exceptions.VehicleNotFound;
import cliente.Cliente;
import database.Database;
import shared_mobility.SharedMobility.src.Patenti;
import veicoli.*;

import java.io.*;
import java.util.Scanner;

public class SharedMobility {
    Scanner sc = new Scanner(System.in);
    private Database db;
    private File fileClienti = new File("src/files/clienti.txt");
    private File fileAffitti = new File("src/files/affitti.txt");

    public SharedMobility() {
        Automobile veicolo1 = new Automobile("ABC", "Benzina", 1, "Roma");
        Automobile veicolo2 = new Automobile("ABC", "Metano", 2, "Milano");
        Automobile veicolo3 = new Automobile("ABC", "Diesel", 0.4, "Torino");
        Automobile veicolo4 = new Automobile("ABC", "Benzina", 1, "Roma");
        Bicicletta veicolo5 = new Bicicletta(0.1, "Pisa");
        Furgoncino veicolo6 = new Furgoncino("ABC", "Metano", 5, "Milano");
        MonopattinoElettrico veicolo7 = new MonopattinoElettrico("CDF",0.1, "Pisa");
        Scooter veicolo8 = new Scooter("ABC", "Benzina", 0.5, "Milano");
        db = new Database();
        db.putVeicolo(veicolo1);
        db.putVeicolo(veicolo2);
        db.putVeicolo(veicolo3);
        db.putVeicolo(veicolo4);
        db.putVeicolo(veicolo5);
        db.putVeicolo(veicolo6);
        db.putVeicolo(veicolo7);
        db.putVeicolo(veicolo8);
    }

    public SharedMobility(Database db) {
        this.db = db;
    }

    // metodo per registrare utente
    // clientSignUp()

    public boolean clientExist(Cliente cliente){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileClienti))){
            String line = bufferedReader.readLine();
            while (line != null){
                if (line.contains(cliente.getCodiceFiscale())){
                    return true;
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public void clientSignUp(Cliente cliente){
        if (clientExist(cliente)){
            System.out.println("Utente già esistente");
            return;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileClienti, true))){
            bufferedWriter.write(cliente + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean canRent(Veicolo veicolo, Cliente cliente){
        if (veicolo instanceof Automobile) {
            for (Patenti patenti : cliente.getPatenti()) {
                if (patenti.equals(Patenti.B)){
                    return true;
                }
            }
            System.out.println("Non disponi della patente necessaria");
            return false;
        } else if (veicolo instanceof Scooter) {
            for (Patenti patenti : cliente.getPatenti()) {
                if (patenti.equals(Patenti.A)){
                    if (cliente.isHaCasco()) {
                        return true;
                    } else {
                        System.out.println("Non disponi del casco");
                        return false;
                    }
                }
            }
            System.out.println("Non disponi della patente necessaria");
            return false;
        } else if (veicolo instanceof MonopattinoElettrico) {
            if (cliente.isHaCasco()){
                return true;
            }
            System.out.println("Non disponi del casco");
            return false;
        } else if (veicolo instanceof Furgoncino) {
            for (Patenti patenti : cliente.getPatenti()) {
                if (patenti.equals(Patenti.C)){
                    return true;
                }
            }
            System.out.println("Non disponi della patente necessaria");
            return false;
        } else if (veicolo instanceof Bicicletta) {
            if (cliente.isHaCasco()){
                return true;
            }
            System.out.println("Non disponi del casco");
            return false;
        }
        return false;
    }

    public void affittaVeicolo(Veicolo veicolo, int tempo, Cliente cliente) throws VehicleBooked {
        if(veicolo.isBooked()) throw new VehicleBooked();
        if(tempo<=5){
            System.out.println("Il veicolo deve essere affittato per più di 5 minuti");
            return;
        }
        if (!canRent(veicolo, cliente)) return;

        if(veicolo instanceof Bicicletta){
            veicolo.booked();
        }
        else {
            veicolo.updateFuel(veicolo.getLivelloCarburante() - (tempo / 3));
            veicolo.booked();
        }
        if (clientExist(cliente)) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileAffitti, true))) {
                bufferedWriter.write("ID Cliente: " + cliente.getIdUtente() + ", ID Veicolo: " + veicolo.getIdVeicolo() + ", Durata: " + tempo + " minuti" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else System.out.println("Utente non esistente");
        System.out.println("Veicolo Affittato Correttamente");
    }

    public void affittaVeicoloByID(int id, int tempo, Cliente cliente) throws VehicleNotFound, VehicleBooked {
        Veicolo veicolo = db.idFilter(id);
        affittaVeicolo(veicolo, tempo, cliente);
    }
    // metodo per cercare veicoli disponibili
    // ricerca(...)
    public void search(int i) throws VehicleNotFound, VehicleBooked {
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
