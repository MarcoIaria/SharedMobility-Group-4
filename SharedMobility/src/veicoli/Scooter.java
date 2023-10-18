package shared_mobility.SharedMobility.src.veicoli;

import shared_mobility.SharedMobility.src.Patenti;

public class Scooter extends Veicolo {
    private String targa;
    private Patenti patenteRichiesta;
    private static final boolean NEED_HELMET = true;

    public Scooter (String targa, String tipoCarburante, double tariffa, String posizione) {
        super(tipoCarburante, tariffa, posizione);
        this.targa = targa;
    }
}
