import Exceptions.VehicleNotFound;
import cliente.Cliente;
import database.Database;
import veicoli.Bicicletta;
import veicoli.Veicolo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SharedMobility {
    Scanner sc = new Scanner(System.in);
    private Database db;
    private File fileClienti = new File("src/files/clienti.txt");
    private File fileAffitti = new File("src/files/affitti.txt");

    public SharedMobility() {
        db = new Database();
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
                    System.out.println("Utente gia esistente");
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
            return;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileClienti, true))){
            bufferedWriter.write(cliente + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void affittaVeicolo(Veicolo veicolo, int tempo, Cliente cliente){
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
        if (clientExist(cliente)) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileAffitti, true))) {
                bufferedWriter.write(cliente.getIdUtente() + veicolo.getIdVeicolo() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
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
