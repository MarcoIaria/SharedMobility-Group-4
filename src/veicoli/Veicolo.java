package veicoli;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public abstract class Veicolo {
    private static int idTot = 0;
    protected int idVeicolo;
    protected String posizione;
    protected boolean isBooked;
    protected String tipoCarburante;
    protected int livelloCarburante;
    protected double tariffa;

    public Veicolo(double tariffa, String posizione) {
        idVeicolo = idTot++;
        this.posizione = posizione.toLowerCase();
        isBooked = false;
        this.tipoCarburante = "";
        livelloCarburante = 100;
        this.tariffa = tariffa;
    }

    public Veicolo(String tipoCarburante, double tariffa, String posizione) {
        idVeicolo = idTot++;
        this.posizione = posizione.toLowerCase();
        isBooked = false;
        this.tipoCarburante = tipoCarburante.toLowerCase();
        livelloCarburante = 100;
        this.tariffa = tariffa;
    }

    public Veicolo() {}

    public String location() {
        return posizione;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public int fuelStatus() {
        return livelloCarburante;
    }

    public void updateFuel(int fuel){
        livelloCarburante = fuel;
    }

    public void booked(){
        isBooked = true;
    }
    public void free(){
        isBooked = false;
    }

    public int getIdVeicolo() {
        return idVeicolo;
    }

    // location()
    // isBooked()
    // fuelStatus()
}
